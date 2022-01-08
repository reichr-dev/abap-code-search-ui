/**
 */
package com.devepos.adt.cst.model.codesearch.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.devepos.adt.base.model.adtbase.IAdtBasePackage;
import com.devepos.adt.cst.model.codesearch.ICodeSearchFactory;
import com.devepos.adt.cst.model.codesearch.ICodeSearchMatch;
import com.devepos.adt.cst.model.codesearch.ICodeSearchObject;
import com.devepos.adt.cst.model.codesearch.ICodeSearchPackage;
import com.devepos.adt.cst.model.codesearch.ICodeSearchResult;
import com.devepos.adt.cst.model.codesearch.ICodeSearchSettings;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class CodeSearchPackage extends EPackageImpl implements ICodeSearchPackage {
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass codeSearchObjectEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass codeSearchMatchEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass codeSearchResultEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass codeSearchSettingsEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
   * package package URI value.
   * <p>
   * Note: the correct way to create the package is via the static factory method
   * {@link #init init()}, which also performs initialization of the package, or
   * returns the registered package, if one already exists. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see com.devepos.adt.cst.model.codesearch.ICodeSearchPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private CodeSearchPackage() {
    super(eNS_URI, ICodeSearchFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and
   * for any others upon which it depends.
   *
   * <p>
   * This method is used to initialize {@link ICodeSearchPackage#eINSTANCE} when
   * that field is accessed. Clients should not invoke it directly. Instead, they
   * should simply access that field to obtain the package. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ICodeSearchPackage init() {
    if (isInited) {
      return (ICodeSearchPackage) EPackage.Registry.INSTANCE.getEPackage(
          ICodeSearchPackage.eNS_URI);
    }

    // Obtain or create and register package
    Object registeredCodeSearchPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    CodeSearchPackage theCodeSearchPackage = registeredCodeSearchPackage instanceof CodeSearchPackage
        ? (CodeSearchPackage) registeredCodeSearchPackage
        : new CodeSearchPackage();

    isInited = true;

    // Initialize simple dependencies
    IAdtBasePackage.eINSTANCE.eClass();
    XMLTypePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theCodeSearchPackage.createPackageContents();

    // Initialize created meta-data
    theCodeSearchPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theCodeSearchPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ICodeSearchPackage.eNS_URI, theCodeSearchPackage);
    return theCodeSearchPackage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getCodeSearchObject() {
    return codeSearchObjectEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getCodeSearchObject_AdtObjectRef() {
    return (EReference) codeSearchObjectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getCodeSearchObject_Matches() {
    return (EReference) codeSearchObjectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getCodeSearchObject_AdtMainObjectRef() {
    return (EReference) codeSearchObjectEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getCodeSearchMatch() {
    return codeSearchMatchEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCodeSearchMatch_Uri() {
    return (EAttribute) codeSearchMatchEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCodeSearchMatch_Snippet() {
    return (EAttribute) codeSearchMatchEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getCodeSearchResult() {
    return codeSearchResultEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EReference getCodeSearchResult_SearchObjects() {
    return (EReference) codeSearchResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getCodeSearchSettings() {
    return codeSearchSettingsEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCodeSearchSettings_PcreEnabled() {
    return (EAttribute) codeSearchSettingsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCodeSearchSettings_ParallelEnabled() {
    return (EAttribute) codeSearchSettingsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getCodeSearchSettings_ParallelServerGroup() {
    return (EAttribute) codeSearchSettingsEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ICodeSearchFactory getCodeSearchFactory() {
    return (ICodeSearchFactory) getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package. This method is guarded to
   * have no affect on any invocation but its first. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) {
      return;
    }
    isCreated = true;

    // Create classes and their features
    codeSearchObjectEClass = createEClass(CODE_SEARCH_OBJECT);
    createEReference(codeSearchObjectEClass, CODE_SEARCH_OBJECT__ADT_OBJECT_REF);
    createEReference(codeSearchObjectEClass, CODE_SEARCH_OBJECT__MATCHES);
    createEReference(codeSearchObjectEClass, CODE_SEARCH_OBJECT__ADT_MAIN_OBJECT_REF);

    codeSearchMatchEClass = createEClass(CODE_SEARCH_MATCH);
    createEAttribute(codeSearchMatchEClass, CODE_SEARCH_MATCH__URI);
    createEAttribute(codeSearchMatchEClass, CODE_SEARCH_MATCH__SNIPPET);

    codeSearchResultEClass = createEClass(CODE_SEARCH_RESULT);
    createEReference(codeSearchResultEClass, CODE_SEARCH_RESULT__SEARCH_OBJECTS);

    codeSearchSettingsEClass = createEClass(CODE_SEARCH_SETTINGS);
    createEAttribute(codeSearchSettingsEClass, CODE_SEARCH_SETTINGS__PCRE_ENABLED);
    createEAttribute(codeSearchSettingsEClass, CODE_SEARCH_SETTINGS__PARALLEL_ENABLED);
    createEAttribute(codeSearchSettingsEClass, CODE_SEARCH_SETTINGS__PARALLEL_SERVER_GROUP);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model. This method is
   * guarded to have no affect on any invocation but its first. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) {
      return;
    }
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    IAdtBasePackage theAdtBasePackage = (IAdtBasePackage) EPackage.Registry.INSTANCE.getEPackage(
        IAdtBasePackage.eNS_URI);
    XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE.getEPackage(
        XMLTypePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes, features, and operations; add parameters
    initEClass(codeSearchObjectEClass, ICodeSearchObject.class, "CodeSearchObject", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCodeSearchObject_AdtObjectRef(), theAdtBasePackage.getAdtObjRef(), null,
        "adtObjectRef", null, 0, 1, ICodeSearchObject.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEReference(getCodeSearchObject_Matches(), getCodeSearchMatch(), null, "matches", null, 0,
        -1, ICodeSearchObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCodeSearchObject_AdtMainObjectRef(), theAdtBasePackage.getAdtObjRef(), null,
        "adtMainObjectRef", null, 0, 1, ICodeSearchObject.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(codeSearchMatchEClass, ICodeSearchMatch.class, "CodeSearchMatch", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCodeSearchMatch_Uri(), ecorePackage.getEString(), "uri", null, 0, 1,
        ICodeSearchMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCodeSearchMatch_Snippet(), ecorePackage.getEString(), "snippet", null, 0, 1,
        ICodeSearchMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(codeSearchResultEClass, ICodeSearchResult.class, "CodeSearchResult", !IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCodeSearchResult_SearchObjects(), getCodeSearchObject(), null,
        "searchObjects", null, 0, -1, ICodeSearchResult.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(codeSearchSettingsEClass, ICodeSearchSettings.class, "CodeSearchSettings",
        !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCodeSearchSettings_PcreEnabled(), theXMLTypePackage.getBoolean(),
        "pcreEnabled", null, 0, 1, ICodeSearchSettings.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCodeSearchSettings_ParallelEnabled(), theXMLTypePackage.getBoolean(),
        "parallelEnabled", null, 0, 1, ICodeSearchSettings.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCodeSearchSettings_ParallelServerGroup(), theXMLTypePackage.getString(),
        "parallelServerGroup", null, 0, 1, ICodeSearchSettings.class, !IS_TRANSIENT, !IS_VOLATILE,
        IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
  }

  /**
   * Initializes the annotations for
   * <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected void createExtendedMetaDataAnnotations() {
    String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
    addAnnotation(codeSearchObjectEClass, source, new String[] { "kind", "elementOnly", "name",
        "searchObject" });
    addAnnotation(getCodeSearchObject_AdtObjectRef(), source, new String[] { "kind", "element",
        "name", "adtObjRef", "namespace", "http://www.devepos.com/adt/base" });
    addAnnotation(getCodeSearchObject_Matches(), source, new String[] { "kind", "element", "name",
        "match", "namespace", "##targetNamespace" });
    addAnnotation(getCodeSearchObject_AdtMainObjectRef(), source, new String[] { "kind", "element",
        "name", "adtMainObjRef", "namespace", "http://www.devepos.com/adt/base" });
    addAnnotation(codeSearchMatchEClass, source, new String[] { "kind", "elementOnly", "name",
        "codeSearchMatch" });
    addAnnotation(getCodeSearchMatch_Uri(), source, new String[] { "kind", "attribute", "name",
        "uri", "namespace", "##targetNamespace" });
    addAnnotation(getCodeSearchMatch_Snippet(), source, new String[] { "kind", "element", "name",
        "snippet", "namespace", "##targetNamespace" });
    addAnnotation(codeSearchResultEClass, source, new String[] { "kind", "elementOnly", "name",
        "result" });
    addAnnotation(getCodeSearchResult_SearchObjects(), source, new String[] { "kind", "element",
        "name", "searchObject", "namespace", "##targetNamespace" });
    addAnnotation(codeSearchSettingsEClass, source, new String[] { "kind", "elementOnly", "name",
        "settings" });
    addAnnotation(getCodeSearchSettings_PcreEnabled(), source, new String[] { "kind", "attribute",
        "name", "pcreEnabled", "namespace", "##targetNamespace" });
    addAnnotation(getCodeSearchSettings_ParallelEnabled(), source, new String[] { "kind",
        "attribute", "name", "parallelEnabled", "namespace", "##targetNamespace" });
    addAnnotation(getCodeSearchSettings_ParallelServerGroup(), source, new String[] { "kind",
        "attribute", "name", "parallelServerGroup", "namespace", "##targetNamespace" });
  }

} // CodeSearchPackage