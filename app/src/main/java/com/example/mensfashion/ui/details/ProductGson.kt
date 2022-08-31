package com.example.mensfashion.ui.details

import com.google.gson.Gson

object ProductGson {

    const val json: String = "[ {\n" +
            "        \"product_images\":[\n" +
            "        \"https://images.yaoota.com/xLGfeWaHtQCtM7vBh49LpXgnmnI=/trim/yaootaweb-production/media/crawledproductimages/164041dedf873176b2ccbce2fe9cd2c2da1bd8d2.jpg\",\n" +
            "        \"https://eg.jumia.is/unsafe/fit-in/300x300/filters:fill(white)/product/41/323742/1.jpg\",\n" +
            "        \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIAPLRY-9CII4sgW2mVKL4D8o0-FXYk__YIj7gYKXJUaG-QyV0S3_Hw7ZWntwQcecf3Fg&usqp=CAU\"\n" +
            "        ],\n" +
            "        \"out_of_stock\":true,\n" +
            "        \"color\":[\n" +
            "        {\n" +
            "            \"color_name\":\"red\",\n" +
            "            \"color_value\":\"#ff0000\",\n" +
            "            \"color_id\":1,\n" +
            "            \"quantity\":10,\n" +
            "            \"sizes\":[\n" +
            "\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"color_name\":\"blue\",\n" +
            "            \"color_value\":\"#0059ff\",\n" +
            "            \"color_id\":2,\n" +
            "            \"quantity\":0,\n" +
            "            \"sizes\":[\n" +
            "            {\n" +
            "                \"size_name\":\"XL\",\n" +
            "                \"size_id\":1,\n" +
            "                \"quantity\":6\n" +
            "            },\n" +
            "            {\n" +
            "                \"size_name\":\"L\",\n" +
            "                \"quantity\":4,\n" +
            "                \"size_id\":2\n" +
            "            },\n" +
            "            {\n" +
            "                \"size_name\":\"M\",\n" +
            "                \"size_id\":3,\n" +
            "                \"quantity\":2\n" +
            "            }\n" +
            "            ]\n" +
            "        }\n" +
            "        ],\n" +
            "        \"product_description\":\"description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description \",\n" +
            "        \"product_name\":\" product Name product\",\n" +
            "        \"product_id\":\"b9d82e00-1de7-11ed-861d-0242ac120002\",\n" +
            "        \"price\":{\n" +
            "        \"old_price\":170.5,\n" +
            "        \"new_price\":155.5,\n" +
            "        \"hase_offer\":true,\n" +
            "        \"expire_date\":\"2022-06-20T20:59:15.288Z\",\n" +
            "        \"cane_request_more_then_one\":false\n" +
            "    },\n" +
            "        \"category\":{\n" +
            "        \"category_name\":\"ملابس رجالي\",\n" +
            "        \"category_id\":1,\n" +
            "        \"section\":{\n" +
            "        \"section_name\":\"Section Name \",\n" +
            "        \"section_id\":1\n" +
            "    }\n" +
            "    }\n" +
            "    },\n" +
            "    {\n" +
            "        \"product_images\":[\n" +
            "        \"https://images.yaoota.com/xLGfeWaHtQCtM7vBh49LpXgnmnI=/trim/yaootaweb-production/media/crawledproductimages/164041dedf873176b2ccbce2fe9cd2c2da1bd8d2.jpg\",\n" +
            "        \"https://eg.jumia.is/unsafe/fit-in/300x300/filters:fill(white)/product/41/323742/1.jpg\",\n" +
            "        \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIAPLRY-9CII4sgW2mVKL4D8o0-FXYk__YIj7gYKXJUaG-QyV0S3_Hw7ZWntwQcecf3Fg&usqp=CAU\"\n" +
            "        ],\n" +
            "        \"out_of_stock\":true,\n" +
            "        \"color\":[\n" +
            "        {\n" +
            "            \"color_name\":\"red\",\n" +
            "            \"color_value\":\"#ff0000\",\n" +
            "            \"color_id\":1,\n" +
            "            \"quantity\":10,\n" +
            "            \"sizes\":[\n" +
            "\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"color_name\":\"blue\",\n" +
            "            \"color_value\":\"#0059ff\",\n" +
            "            \"color_id\":2,\n" +
            "            \"quantity\":0,\n" +
            "            \"sizes\":[\n" +
            "            {\n" +
            "                \"size_name\":\"XL\",\n" +
            "                \"size_id\":1,\n" +
            "                \"quantity\":6\n" +
            "            },\n" +
            "            {\n" +
            "                \"size_name\":\"L\",\n" +
            "                \"quantity\":4,\n" +
            "                \"size_id\":2\n" +
            "            },\n" +
            "            {\n" +
            "                \"size_name\":\"M\",\n" +
            "                \"size_id\":3,\n" +
            "                \"quantity\":2\n" +
            "            }\n" +
            "            ]\n" +
            "        }\n" +
            "        ],\n" +
            "        \"product_description\":\"description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description description \",\n" +
            "        \"product_name\":\" product Name product\",\n" +
            "        \"product_id\":\"b9d82e00-1de7-11ed-861d-0242ac120002\",\n" +
            "        \"price\":{\n" +
            "        \"old_price\":170.5,\n" +
            "        \"new_price\":155.5,\n" +
            "        \"hase_offer\":true,\n" +
            "        \"expire_date\":\"2022-06-20T20:59:15.288Z\",\n" +
            "        \"cane_request_more_then_one\":false\n" +
            "    },\n" +
            "        \"category\":{\n" +
            "        \"category_name\":\"ملابس رجالي\",\n" +
            "        \"category_id\":1,\n" +
            "        \"section\":{\n" +
            "        \"section_name\":\"Section Name \",\n" +
            "        \"section_id\":1\n" +
            "    }\n" +
            "    }\n" +
            "    }\n" +
            "]"
}

    inline fun <reified T> Gson.fromJson(json: String) =
        fromJson(json, T::class.java)
