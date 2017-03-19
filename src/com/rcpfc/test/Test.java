package com.rcpfc.test;

import java.io.IOException;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;

public class Test {

	public static void main( String[] args ) throws IOException, ProcessingException
	{
	    String schemaFile = "{     \"$schema\": \"http://json-schema.org/draft-04/schema#\",     \"title\": \"Product\",     \"description\": \"A product from Acme's catalog\",     \"type\": \"object\",     \"properties\": {         \"id\": {             \"description\": \"The unique identifier for a product\",             \"type\": \"integer\"         },         \"name\": {             \"description\": \"Name of the product\",             \"type\": \"string\"         },         \"price\": {             \"type\": \"number\",             \"minimum\": 0,             \"exclusiveMinimum\": true         },         \"tags\": {             \"type\": \"array\",             \"items\": {                 \"type\": \"string\"             },             \"minItems\": 1,             \"uniqueItems\": true         }     },     \"required\": [\"id\", \"name\", \"price\"] }";
	    String jsonFile = "{     \"id\": 1,     \"name\": \"A green door\",     \"price\": 12.50,     \"tags\": [\"home\", \"green\"] }";
	    	
	    if (ValidationUtils.isJsonValid(schemaFile, jsonFile)){
	    	System.out.println("Valid!");
	    }else{
	    	System.out.println("NOT valid!");
	    }
	}
}
