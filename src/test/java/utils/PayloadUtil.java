package utils;

public class PayloadUtil {
    public static String getPetPayload(int id,String petName,String petstatus) {
        String petPayload = "{\n" +
                "  \"id\":"+id+",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \""+petName+"\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" +petstatus+ "\"\n" +
                "}";

        return petPayload;
    }

    public static String getSlackMessagePayload(String message){
        String payload="{\n" +
                "    \"channel\":\"C0397J4JY3T\", \n" +
                "    \"text\":\"Jing:"+message+"\" \n" +
                "}";
                return payload;

    }

}

