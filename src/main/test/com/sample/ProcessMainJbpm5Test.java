package com.sample;


import org.jbpm.test.JbpmJUnitTestCase;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;

public class ProcessMainJbpm5Test extends JbpmJUnitTestCase {
	
	@Test
	public void testProcess() {
		KieSession ksession = createKnowledgeSession("com/sample/jbpm5.bpmn");	
		ProcessInstance pl = ksession.startProcess("jbpm5");
		
		assertProcessInstanceCompleted(pl.getId(), ksession);
		assertNodeTriggered(pl.getId(), "Hello");
	}

}
