package ru.agentlab.maia.agent.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ru.agentlab.maia.agent.annotation.converter.OnBeliefXXXConverter;
import ru.agentlab.maia.agent.event.RemovedGoalObjectPropertyAssertionAxiomEvent;
import ru.agentlab.maia.converter.PlanEventFilterConverter;
import ru.agentlab.maia.converter.PlanEventType;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@PlanEventType(RemovedGoalObjectPropertyAssertionAxiomEvent.class)
@PlanEventFilterConverter(OnBeliefXXXConverter.class)
public @interface RemovedGoalObjectPropertyAssertionAxiom {

	String[] value() default { "?$1", "?$2", "?$3" };

}
