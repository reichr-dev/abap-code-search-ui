package com.devepos.adt.cst.ui.internal.codesearch;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Text;

import com.devepos.adt.base.ui.project.IAbapProjectProvider;
import com.devepos.adt.base.util.StringUtil;
import com.devepos.adt.cst.model.codesearch.ICodeSearchFactory;
import com.devepos.adt.cst.model.codesearch.ICodeSearchScopeParameter;
import com.devepos.adt.cst.model.codesearch.ICodeSearchScopeParameters;
import com.devepos.adt.cst.ui.internal.CodeSearchUIPlugin;
import com.devepos.adt.cst.ui.internal.messages.Messages;
import com.devepos.adt.cst.ui.internal.preferences.ICodeSearchPrefs;
import com.sap.adt.destinations.model.IDestinationData;

/**
 * Describes all the options that are needed to execute a
 * {@link CodeSearchQuery}
 *
 * @author Ludwig Stockbauer-Muhr
 *
 */
public class CodeSearchQuerySpecification {

  private String destinationId;
  private IAbapProjectProvider projectProvider;

  private boolean ignoreCaseCheck;
  private boolean ignoreCommentLines;
  private boolean matchAllPatterns;
  private boolean sequentialMatching;
  private boolean multilineSearchOption;

  private boolean readPackageHierarchy;

  private boolean singlePattern;
  private boolean useRegExp;
  private String patterns = "";
  private String objectNames = "";

  private IncludeFlagsParameter classIncludesParam;
  private IncludeFlagsParameter fugrIncludesParam;
  private Map<String, Object> objectScopeFilters;
  private String objectScopeFiltersString = "";

  public CodeSearchQuerySpecification() {
    destinationId = null;
  }

  /**
   * Builds map of necessary URI parameters for executing the object search
   *
   * @return map of URI parameters
   */
  public Map<String, Object> buildSearchUriParameters() {
    Map<String, Object> uriParameters = new HashMap<>();

    uriParameters.put(FilterName.SEARCH_PATTERN.getUriParamName(), getAdjustedPatterns());
    if (ignoreCaseCheck) {
      uriParameters.put(SearchParameter.IGNORE_CASE.getUriName(), true);
    }
    if (ignoreCommentLines) {
      uriParameters.put(SearchParameter.IGNORE_COMMENT_LINES.getUriName(), true);
    }
    if (multilineSearchOption) {
      uriParameters.put(SearchParameter.MULTI_LINE.getUriName(), true);
    }
    if (useRegExp) {
      uriParameters.put(SearchParameter.USE_REGEX.getUriName(), true);
    }
    if (matchAllPatterns) {
      uriParameters.put(SearchParameter.MATCH_ALL.getUriName(), true);
    }
    if (sequentialMatching) {
      uriParameters.put(SearchParameter.SEQUENTIAL_MATCHING.getUriName(), true);
    }
    uriParameters.put(SearchParameter.CLASS_INCLUDES.getUriName(), getClassIncludesParam()
        .getUriParamValue());
    uriParameters.put(SearchParameter.FUGR_INCLUDES.getUriName(), getFugrIncludesParam()
        .getUriParamValue());

    setParamsFromPrefStore(uriParameters);

    return uriParameters;
  }

  public ICodeSearchScopeParameters createScopeParameters() {
    ICodeSearchScopeParameters scopeParameters = ICodeSearchFactory.eINSTANCE
        .createCodeSearchScopeParameters();

    if (!StringUtil.isBlank(objectNames)) {
      ICodeSearchScopeParameter parameter = ICodeSearchFactory.eINSTANCE
          .createCodeSearchScopeParameter();
      parameter.setName(FilterName.OBJECT_NAME.getUriParamName());
      parameter.setValue(objectNames);
      scopeParameters.getParameters().add(parameter);
    }
    getObjectScopeFilters().forEach((paramName, paramValue) -> {
      ICodeSearchScopeParameter parameter = ICodeSearchFactory.eINSTANCE
          .createCodeSearchScopeParameter();
      parameter.setName(paramName);
      parameter.setValue((String) paramValue);
      scopeParameters.getParameters().add(parameter);
    });
    return scopeParameters;
  }

  @Override
  public boolean equals(final Object object) {
    if (!(object instanceof CodeSearchQuerySpecification)) {
      return super.equals(object);
    }
    final CodeSearchQuerySpecification otherEntry = (CodeSearchQuerySpecification) object;
    return getQuery(false).equalsIgnoreCase(otherEntry.getQuery(false)) && getDestinationId()
        .equalsIgnoreCase(otherEntry.getDestinationId())
        && matchAllPatterns == otherEntry.matchAllPatterns;
  }

  public IncludeFlagsParameter getClassIncludesParam() {
    if (classIncludesParam == null) {
      classIncludesParam = new IncludeFlagsParameter(ClassInclude.values());
    }
    return classIncludesParam;
  }

  public String getDestinationId() {
    return projectProvider != null ? projectProvider.getDestinationId()
        : destinationId != null ? destinationId : "";
  }

  public IncludeFlagsParameter getFugrIncludesParam() {
    if (fugrIncludesParam == null) {
      fugrIncludesParam = new IncludeFlagsParameter(FunctionGroupInclude.values());
    }
    return fugrIncludesParam;
  }

  public String getObjectNames() {
    return objectNames;
  }

  public Map<String, Object> getObjectScopeFilters() {
    return objectScopeFilters != null ? objectScopeFilters : new HashMap<>();
  }

  public String getObjectScopeFiltersString() {
    return objectScopeFiltersString != null ? objectScopeFiltersString : "";
  }

  public String getPatterns() {
    return patterns != null ? patterns : "";
  }

  public IAbapProjectProvider getProjectProvider() {
    return projectProvider;
  }

  public String getQuery(final boolean restrictString) {
    if (restrictString) {
      String query = singlePattern ? patterns.replaceAll(Text.DELIMITER, "\\\\n")
          : patterns.replaceAll(Text.DELIMITER, ",");
      if (query.length() > 60) {
        query = query.substring(0, 60) + "...";
      }
      return String.format("'%s'", query);
    }
    StringBuffer query = new StringBuffer();
    if (!StringUtil.isEmpty(objectNames) || !StringUtil.isEmpty(objectNames) || !StringUtil.isEmpty(
        objectScopeFiltersString)) {
      query.append(Messages.CodeSearchQuerySpecification_patternQueryPart_xtol);
    }
    query.append("'");
    query.append(singlePattern ? patterns.replaceAll(Text.DELIMITER, "\\\\n")
        : patterns.replaceAll(Text.DELIMITER, ","));
    query.append("'");
    if (!StringUtil.isBlank(objectNames)) {
      query.append("\n");
      query.append(Messages.CodeSearchQuerySpecification_objectNameQueryPart_xtol);
      query.append(": '");
      query.append(objectNames);
      query.append("'");
    }
    if (!StringUtil.isBlank(objectScopeFiltersString)) {
      query.append("\n");
      query.append(Messages.CodeSearchQuerySpecification_scopeQueyPart_xtol);
      query.append(": '");
      query.append(objectScopeFiltersString);
      query.append("'");
    }
    return query.toString();
  }

  public boolean isIgnoreCaseCheck() {
    return ignoreCaseCheck;
  }

  public boolean isIgnoreCommentLines() {
    return ignoreCommentLines;
  }

  public boolean isMatchAllPatterns() {
    return matchAllPatterns;
  }

  public boolean isMultilineSearchOption() {
    return multilineSearchOption;
  }

  /**
   * @return the readPackageHierarchy
   */
  public boolean isReadPackageHierarchy() {
    return readPackageHierarchy;
  }

  public boolean isSequentialMatching() {
    return sequentialMatching;
  }

  public boolean isSinglePattern() {
    return singlePattern;
  }

  public boolean isUseRegExp() {
    return useRegExp;
  }

  public void setClassIncludesParam(final IncludeFlagsParameter classIncludesParam) {
    this.classIncludesParam = classIncludesParam;
  }

  public void setDestinationId(final String destinationId) {
    this.destinationId = destinationId;
  }

  public void setFugrIncludesParam(final IncludeFlagsParameter fugrIncludesParam) {
    this.fugrIncludesParam = fugrIncludesParam;
  }

  public void setIgnoreCaseCheck(final boolean ignoreCaseCheck) {
    this.ignoreCaseCheck = ignoreCaseCheck;
  }

  public void setIgnoreCommentLines(final boolean ignoreCommentLines) {
    this.ignoreCommentLines = ignoreCommentLines;
  }

  public void setMatchAllPatterns(final boolean matchAllPatterns) {
    this.matchAllPatterns = matchAllPatterns;
  }

  public void setMultilineSearchOption(final boolean multilineSearchOption) {
    this.multilineSearchOption = multilineSearchOption;
  }

  public void setObjectNames(final String objectNames) {
    this.objectNames = objectNames.strip().replaceAll("\\s+", " ");
  }

  public void setObjectScopeFilters(final Map<String, Object> objectScopeFilters,
      final String objectScopeFiltersString) {
    this.objectScopeFilters = objectScopeFilters;
    this.objectScopeFiltersString = objectScopeFiltersString;
  }

  public void setPatterns(final String searchTerm) {
    patterns = searchTerm;
  }

  public void setProjectProvider(final IAbapProjectProvider projectProvider) {
    this.projectProvider = projectProvider;
  }

  /**
   * @param readPackageHierarchy the readPackageHierarchy to set
   */
  public void setReadPackageHierarchy(final boolean readPackageHierarchy) {
    this.readPackageHierarchy = readPackageHierarchy;
  }

  public void setSequentialMatching(final boolean sequentialMatching) {
    this.sequentialMatching = sequentialMatching;
  }

  public void setSinglePattern(final boolean singlePattern) {
    this.singlePattern = singlePattern;
  }

  public void setUseRegExp(final boolean useRegExp) {
    this.useRegExp = useRegExp;
  }

  @Override
  public String toString() {
    final String destinationInfo = getDestinationInfo();
    if (destinationInfo.isEmpty()) {
      return getQuery(true);
    }
    return String.format("%s [%s]", getQuery(true), destinationInfo);
  }

  private Object getAdjustedPatterns() {
    if (singlePattern) {
      String lineBreakReplacement = null;
      if (useRegExp) {
        if (CodeSearchUIPlugin.getDefault()
            .getPreferenceStore()
            .getBoolean(ICodeSearchPrefs.SINGLE_PATTERN_REGEX_CONCAT_WITH_LF)) {
          lineBreakReplacement = "\\\n";
        } else {
          lineBreakReplacement = "";
        }
      } else {
        lineBreakReplacement = System.lineSeparator();
      }
      return patterns.replaceAll(Text.DELIMITER, lineBreakReplacement);
    }
    return Stream.of(patterns.split(Text.DELIMITER))
        .filter(pattern -> !pattern.isBlank())
        .collect(Collectors.toList());
  }

  private String getDestinationInfo() {
    if (projectProvider == null || !projectProvider.hasProject()) {
      return "";
    }
    final IDestinationData destData = projectProvider.getDestinationData();
    return String.format("%s-%s", destData.getSystemConfiguration().getSystemId(), destData
        .getClient());
  }

  private void setParamsFromPrefStore(final Map<String, Object> uriParameters) {
    IPreferenceStore prefStore = CodeSearchUIPlugin.getDefault().getPreferenceStore();
    uriParameters.put(SearchParameter.MAX_OBJECTS.getUriName(), prefStore.getInt(
        ICodeSearchPrefs.MAX_OBJECTS));
  }
}
