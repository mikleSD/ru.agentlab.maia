package ru.agentlab.maia.agent.annotation;

public enum AxiomType {

	DECLARATION(1),

	EQUIVALENT_CLASSES(-1),

	SUBCLASS_OF(2),

	DISJOINT_CLASSES(-1),

	DISJOINT_UNION(-1),

	CLASS_ASSERTION(2),

	SAME_INDIVIDUAL(-1),

	DIFFERENT_INDIVIDUALS(-1),

	OBJECT_PROPERTY_ASSERTION(3),

	NEGATIVE_OBJECT_PROPERTY_ASSERTION(3),

	DATA_PROPERTY_ASSERTION(3),

	NEGATIVE_DATA_PROPERTY_ASSERTION(3),

	EQUIVALENT_OBJECT_PROPERTIES(-1),

	SUB_OBJECT_PROPERTY(2),

	INVERSE_OBJECT_PROPERTIES(2),

	FUNCTIONAL_OBJECT_PROPERTY(2),

	INVERSE_FUNCTIONAL_OBJECT_PROPERTY(1),

	SYMMETRIC_OBJECT_PROPERTY(1),

	ASYMMETRIC_OBJECT_PROPERTY(1),

	TRANSITIVE_OBJECT_PROPERTY(1),

	REFLEXIVE_OBJECT_PROPERTY(1),

	IRREFLEXIVE_OBJECT_PROPERTY(1),

	OBJECT_PROPERTY_DOMAIN(2),

	OBJECT_PROPERTY_RANGE(2),

	DISJOINT_OBJECT_PROPERTIES(-1),

	SUB_PROPERTY_CHAIN_OF(2),

	EQUIVALENT_DATA_PROPERTIES(-1),

	SUB_DATA_PROPERTY(2),

	FUNCTIONAL_DATA_PROPERTY(1),

	DATA_PROPERTY_DOMAIN(2),

	DATA_PROPERTY_RANGE(2),

	DISJOINT_DATA_PROPERTIES(-1),

	DATATYPE_DEFINITION(2),

	HAS_KEY(2),

	SWRL_RULE(2),

	ANNOTATION_ASSERTION(3),

	SUB_ANNOTATION_PROPERTY_OF(2),

	ANNOTATION_PROPERTY_RANGE(2),

	ANNOTATION_PROPERTY_DOMAIN(2);

	int arity;

	public int getArity() {
		return arity;
	}

	private AxiomType(int arity) {
		this.arity = arity;
	}

}