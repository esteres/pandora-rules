package com.pandora.api.services;

import com.pandora.api.facts.Item;
import org.drools.KnowledgeBase;
import org.drools.runtime.StatefulKnowledgeSession;
import com.pandora.api.engine.EngineBase;

import java.lang.Double;
import java.lang.Throwable;

/**
 * Created by developer on 9/26/15.
 */

public class EngineService {

    public Double getFinalPrice() {
        try {
            EngineBase instanceEngine = new EngineBase();
            KnowledgeBase kbase = instanceEngine.readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();

            Item item = new Item();
            item.setSku("1237");
            item.setPrice(42.0);
            ksession.insert(item);

            ksession.fireAllRules();
            ksession.dispose();

            return item.getPrice();

        }catch (Throwable t){
            t.printStackTrace();

            return 0.0;
        }
    }
}