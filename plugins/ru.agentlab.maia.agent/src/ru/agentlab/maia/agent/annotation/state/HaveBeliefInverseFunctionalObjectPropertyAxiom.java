package ru.agentlab.maia.agent.annotation.state;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ru.agentlab.maia.agent.annotation.converter.OnBeliefXXXConverter;
import ru.agentlab.maia.agent.annotation.internal.HaveBeliefsInverseFunctionalObjectPropertyAxiom;
import ru.agentlab.maia.agent.converter.PlanEventFilterConverter;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(HaveBeliefsInverseFunctionalObjectPropertyAxiom.class)
@PlanEventFilterConverter(OnBeliefXXXConverter.class)
public @interface HaveBeliefInverseFunctionalObjectPropertyAxiom {

	String[] value() default { "?$1", "?$2", "?$3" };

}
