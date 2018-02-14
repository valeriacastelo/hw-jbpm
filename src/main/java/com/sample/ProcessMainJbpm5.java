package com.sample;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

public class ProcessMainJbpm5 {
	
	public static final void main(String[] args) throws Exception {
        // load up the knowledge base
        KnowledgeBase kbase = readKnowledgeBase();
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
         
        Map<String, Object> params = new HashMap<String, Object>();
 
        params.put("name", "Arthur");
         
        // start a new process instance
        ksession.startProcess("jbpm5",params);
    }
	
	private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("com/sample/jbpm5.bpmn"), ResourceType.BPMN2);
        return kbuilder.newKnowledgeBase();
    }

}
