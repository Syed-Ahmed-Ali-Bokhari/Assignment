package org.assignment.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Payloads {

    public static String getBrandPayload() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode requestBody = mapper.createObjectNode();
        requestBody.put("id", "led_46RD27241607Mof19J067201");

        ObjectNode name = mapper.createObjectNode();
        name.put("en", "Demo Account");
        requestBody.set("name", name);

        ObjectNode channelService = mapper.createObjectNode();
        channelService.put("channel", "website");
        channelService.put("address", "https://www.website.company/");
        ArrayNode channelServices = mapper.createArrayNode();
        channelServices.add(channelService);
        requestBody.set("channel_services", channelServices);

        ObjectNode type = mapper.createObjectNode();
        type.put("code", "non_profit");
        ObjectNode team = mapper.createObjectNode();
        team.put("code", "small");

        ObjectNode segment = mapper.createObjectNode();
        segment.set("type", type);
        segment.set("team", team);
        requestBody.set("segment", segment);

        ObjectNode sales = mapper.createObjectNode();
        sales.put("period", "monthly");
        ObjectNode range = mapper.createObjectNode();
        range.put("from", "0");
        range.put("to", "20000");
        sales.set("range", range);
        sales.put("currency", "AED");

        ObjectNode operations = mapper.createObjectNode();
        operations.set("sales", sales);
        requestBody.set("operations", operations);

        ObjectNode termGeneral = mapper.createObjectNode();
        termGeneral.put("term", "general");
        termGeneral.put("agree", true);
        ObjectNode termChargeback = mapper.createObjectNode();
        termChargeback.put("term", "chargeback");
        termChargeback.put("agree", true);
        ObjectNode termRefund = mapper.createObjectNode();
        termRefund.put("term", "refund");
        termRefund.put("agree", true);
        ArrayNode terms = mapper.createArrayNode();
        terms.add(termGeneral);
        terms.add(termChargeback);
        terms.add(termRefund);

        requestBody.set("terms", terms);
        requestBody.put("reference_lead_id", "669a8d9ac825ed28718bf4c5");

        return requestBody.toString();
    }

    public static String getWalletPayload() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode requestBody = mapper.createObjectNode();

        ObjectNode bank = mapper.createObjectNode();
        bank.put("name", "ADBC");

        ObjectNode account = mapper.createObjectNode();
        account.put("name", "ABC");
        account.put("number", "77777777777");
        account.put("swift", "77777777777");
        account.put("iban", "AE0430000565608010759584");

        bank.set("account", account);

        ObjectNode document = mapper.createObjectNode();
        document.put("type", "Bank Statement");
        document.put("number", "9876543221");
        document.put("issuing_country", "AE");
        document.put("issuing_date", "2019-07-09");

        ArrayNode documents = mapper.createArrayNode();
        documents.add(document);
        bank.set("documents", documents);

        requestBody.set("bank", bank);

        return requestBody.toString();

    }
}
