package com.pandora.api.engine;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.lang.System;

/**
 * Created by developer on 9/28/15.
 */
public class EngineBase {

    public EngineBase() {
    }

    public KnowledgeBase readKnowledgeBase() throws Exception{
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        Reader reader = getRuleFileAsReader("/com/rules/files/Item.drl");
        kbuilder.add(ResourceFactory.newReaderResource(reader), ResourceType.DRL);

        KnowledgeBuilderErrors errors = kbuilder.getErrors();

        if(errors.size() > 0){
            for (KnowledgeBuilderError error: errors){
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }

    private  Reader getRuleFileAsReader(String ruleFile) {
        InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

        return new InputStreamReader(resourceAsStream);
    }
}