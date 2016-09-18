/*******************************************************************************
 * Copyright (c) 2016 AgentLab.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ru.agentlab.maia.fipa;

import static ru.agentlab.maia.fipa.FIPAPerformativeNames.AGREE;
import static ru.agentlab.maia.fipa.FIPAPerformativeNames.CANCEL;
import static ru.agentlab.maia.fipa.FIPAPerformativeNames.INFORM;
import static ru.agentlab.maia.fipa.FIPAPerformativeNames.REFUSE;
import static ru.agentlab.maia.fipa.FIPAPerformativeNames.SUBSCRIBE;
import static ru.agentlab.maia.fipa.FIPAProtocolNames.FIPA_SUBSCRIBE;

import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.semanticweb.owlapi.model.OWLAxiom;

import ru.agentlab.maia.agent.IAgent;
import ru.agentlab.maia.agent.IMessage;
import ru.agentlab.maia.belief.IBeliefBase;
import ru.agentlab.maia.message.IMessageDeliveryService;
import ru.agentlab.maia.message.annotation.OnMessageReceived;
import ru.agentlab.maia.message.impl.AclMessage;

public class FIPASubscribeInitiator {

	private String conversationId;

	@Inject
	private IBeliefBase beliefBase;

	@Inject
	private IMessageDeliveryService messaging;

	@Inject
	private UUID targetAgent;

	@Inject
	private String template;

	public FIPASubscribeInitiator(UUID targetAgent, String template) {
		this.targetAgent = targetAgent;
		this.template = template;
	}

	@PostConstruct
	public void onSetup(IAgent agent) {
		conversationId = UUID.randomUUID().toString();
		IMessage message = createMessageToTargetAgent(agent);
		message.setPerformative(SUBSCRIBE);
		message.setContent(template);
		messaging.send(message);
	}

	@OnMessageReceived(performative = AGREE, protocol = FIPA_SUBSCRIBE)
	public void onAgree(IMessage message) {
		if (!checkConversationId(message)) {
			return;
		}
	}

	@OnMessageReceived(performative = REFUSE, protocol = FIPA_SUBSCRIBE)
	public void onRefuse(IMessage message) {
		if (!checkConversationId(message)) {
			return;
		}
	}

	@OnMessageReceived(performative = INFORM, protocol = FIPA_SUBSCRIBE)
	public void onInform(IMessage message) {
		if (!checkConversationId(message)) {
			return;
		}
		OWLAxiom axiom = getAxiom(message);
		beliefBase.addBelief(axiom);
	}

	@PreDestroy
	public void onDestroy(IAgent agent) {
		IMessage message = createMessageToTargetAgent(agent);
		message.setPerformative(CANCEL);
		messaging.send(message);
		conversationId = null;
	}

	private IMessage createMessageToTargetAgent(IAgent agent) {
		IMessage message = new AclMessage();
		message.setSender(agent.getUuid());
		message.setReceiver(targetAgent);
		message.setProtocol(FIPA_SUBSCRIBE);
		message.setConversationId(conversationId);
		return message;
	}

	private boolean checkConversationId(IMessage message) {
		return message.getConversationId().equals(conversationId);
	}

	private OWLAxiom getAxiom(IMessage message) {
		//
		//
		// TODO: extract belief from message
		//
		//
		return null;
	}

}