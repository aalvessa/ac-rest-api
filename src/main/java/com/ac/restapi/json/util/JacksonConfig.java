package com.ac.restapi.json.util;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;

@Provider
public class JacksonConfig implements ContextResolver<ObjectMapper>
{
    private final ObjectMapper objectMapper;

    public JacksonConfig() throws Exception
    {
    	ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(org.codehaus.jackson.map.SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION);
        this.objectMapper = objectMapper;
    }

    @Override
    public ObjectMapper getContext(Class<?> arg0)
    {
        return objectMapper;
    }
 }