package com.manlift.questionnaire.core.repository

import com.manlift.questionnaire.model.Questions
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor()  {

    fun getQuestions():Questions {
        return Gson().fromJson(response,Questions::class.java)

    }
    private var response:String ="{\n" +
            "  \"data\": {\n" +
            "    \"categoryList\": [\n" +
            "      {\n" +
            "        \"cname\": \"Problems on Trains\",\n" +
            "        \"qlist\": [\n" +
            "          {\n" +
            "            \"number\": \"1\",\n" +
            "            \"question\": \"A train running at the speed of 60 km/hr crosses a pole in 9 seconds. What is the length of the train?\",\n" +
            "            \"answer_a\": \"120 metres\",\n" +
            "            \"answer_b\": \"180 metres\",\n" +
            "            \"answer_c\": \"324 metres\",\n" +
            "            \"answer_d\": \"150 metres\",\n" +
            "            \"right_answer\": 4,\n" +
            "            \"selectedoption\": -1\n" +
            "          },\n" +
            "          {\n" +
            "            \"number\": \"2\",\n" +
            "            \"question\": \"A train 125 m long passes a man, running at 5 km/hr in the same direction in which the train is going, in 10 seconds. The speed of the train is:\",\n" +
            "            \"answer_a\": \"45 km/hr\",\n" +
            "            \"answer_b\": \"50 km/hr\",\n" +
            "            \"answer_c\": \"54 km/hr\",\n" +
            "            \"answer_d\": \"55 km/hr\",\n" +
            "            \"right_answer\": 2,\n" +
            "            \"selectedoption\": -1\n" +
            "          },\n" +
            "          {\n" +
            "            \"number\": \"3\",\n" +
            "            \"question\": \"The length of the bridge, which a train 130 metres long and travelling at 45 km/hr can cross in 30 seconds, is:\",\n" +
            "            \"answer_a\": \"200 m\",\n" +
            "            \"answer_b\": \"225 m\",\n" +
            "            \"answer_c\": \"245 m\",\n" +
            "            \"answer_d\": \"250 m\",\n" +
            "            \"right_answer\": 3,\n" +
            "            \"selectedoption\": -1\n" +
            "          },\n" +
            "          {\n" +
            "            \"number\": \"4\",\n" +
            "            \"question\": \"Two trains running in opposite directions cross a man standing on the platform in 27 seconds and 17 seconds respectively and they cross each other in 23 seconds. The ratio of their speeds is:\",\n" +
            "            \"answer_a\": \"1 : 3\",\n" +
            "            \"answer_b\": \"3 : 2\",\n" +
            "            \"answer_c\": \"3 : 4\",\n" +
            "            \"answer_d\": \"None of the above\",\n" +
            "            \"right_answer\": 2,\n" +
            "            \"selectedoption\": -1\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"cname\": \"Height and Distance \",\n" +
            "        \"qlist\": [\n" +
            "          {\n" +
            "            \"number\": \"5\",\n" +
            "            \"question\": \"Two ships are sailing in the sea on the two sides of a lighthouse. The angle of elevation of the top of the lighthouse is observed from the ships are 30° and 45° respectively. If the lighthouse is 100 m high, the distance between the two ships is:\",\n" +
            "            \"answer_a\": \"173 m\",\n" +
            "            \"answer_b\": \"200 m\",\n" +
            "            \"answer_c\": \"273 m\",\n" +
            "            \"answer_d\": \"300 m\",\n" +
            "            \"right_answer\": 3,\n" +
            "            \"selectedoption\": -1\n" +
            "          },\n" +
            "          {\n" +
            "            \"number\": \"6\",\n" +
            "            \"question\": \"A man standing at a point P is watching the top of a tower, which makes an angle of elevation of 30° with the man's eye. The man walks some distance towards the tower to watch its top and the angle of the elevation becomes 60°. What is the distance between the base of the tower and the point P?\",\n" +
            "            \"answer_a\": \"None of these\",\n" +
            "            \"answer_b\": \"8 units\",\n" +
            "            \"answer_c\": \"12 units\",\n" +
            "            \"right_answer\": 4,\n" +
            "            \"answer_d\": \"Data inadequate\",\n" +
            "            \"selectedoption\": -1\n" +
            "          },\n" +
            "          {\n" +
            "            \"number\": \"7\",\n" +
            "            \"question\": \"The angle of elevation of a ladder leaning against a wall is 60° and the foot of the ladder is 4.6 m away from the wall. The length of the ladder is:\",\n" +
            "            \"answer_a\": \"2.3 m\",\n" +
            "            \"answer_b\": \"4.6 m\",\n" +
            "            \"answer_c\": \"7.8 m\",\n" +
            "            \"answer_d\": \"9.2 m\",\n" +
            "            \"right_answer\": 4,\n" +
            "            \"selectedoption\": -1\n" +
            "          },\n" +
            "          {\n" +
            "            \"number\": \"8\",\n" +
            "            \"question\": \"The angle of elevation of the sun, when the length of the shadow of a tree 3 times the height of the tree, is:\",\n" +
            "            \"answer_a\": \"2.3 m\",\n" +
            "            \"answer_b\": \"4.6 m\",\n" +
            "            \"answer_c\": \"7.8 m\",\n" +
            "            \"answer_d\": \"9.2 m\",\n" +
            "            \"right_answer\": 4,\n" +
            "            \"selectedoption\": -1\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"cname\": \"Profit and Loss\",\n" +
            "        \"qlist\": [\n" +
            "          {\n" +
            "            \"number\": \"9\",\n" +
            "            \"question\": \"The cost price of 20 articles is the same as the selling price of x articles. If the profit is 25%, then the value of x is:\",\n" +
            "            \"answer_a\": \"15\",\n" +
            "            \"answer_b\": \"16\",\n" +
            "            \"answer_c\": \"18\",\n" +
            "            \"answer_d\": \"25\",\n" +
            "            \"right_answer\": 2,\n" +
            "            \"selectedoption\": -1\n" +
            "          },\n" +
            "          {\n" +
            "            \"number\": \"10\",\n" +
            "            \"question\": \"In a certain store, the profit is 320% of the cost. If the cost increases by 25% but the selling price remains constant, approximately what percentage of the selling price is the profit?\",\n" +
            "            \"answer_a\": \"30%\",\n" +
            "            \"answer_b\": \"70%\",\n" +
            "            \"answer_c\": \"100%\",\n" +
            "            \"right_answer\": 2,\n" +
            "            \"answer_d\": \"250%\",\n" +
            "            \"selectedoption\": -1\n" +
            "          },\n" +
            "          {\n" +
            "            \"number\": \"11\",\n" +
            "            \"question\": \"A vendor bought toffees at 6 for a rupee. How many for a rupee must he sell to gain 20%?\",\n" +
            "            \"answer_a\": \"3\",\n" +
            "            \"answer_b\": \"4\",\n" +
            "            \"answer_c\": \"5\",\n" +
            "            \"answer_d\": \"6\",\n" +
            "            \"right_answer\": 3,\n" +
            "            \"selectedoption\": -1\n" +
            "          },\n" +
            "          {\n" +
            "            \"number\": \"12\",\n" +
            "            \"question\": \"The percentage profit earned by selling an article for Rs. 1920 is equal to the percentage loss incurred by selling the same article for Rs. 1280. At what price should the article be sold to make 25% profit?\",\n" +
            "            \"answer_a\": \"Rs. 2000\",\n" +
            "            \"answer_b\": \"Rs. 2200\",\n" +
            "            \"answer_c\": \"Rs. 2400\",\n" +
            "            \"answer_d\": \"Data inadequate\",\n" +
            "            \"right_answer\": 1,\n" +
            "            \"selectedoption\": -1\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"cname\": \"Clock\",\n" +
            "        \"qlist\": [\n" +
            "          {\n" +
            "            \"number\": \"13\",\n" +
            "            \"question\": \"An accurate clock shows 8 o'clock in the morning. Through how may degrees will the hour hand rotate when the clock shows 2 o'clock in the afternoon?\",\n" +
            "            \"answer_a\": \"144°\",\n" +
            "            \"answer_b\": \"155°\",\n" +
            "            \"answer_c\": \"168°\",\n" +
            "            \"answer_d\": \"180°\",\n" +
            "            \"right_answer\": 4,\n" +
            "            \"selectedoption\": -1\n" +
            "          },\n" +
            "          {\n" +
            "            \"number\": \"14\",\n" +
            "            \"question\": \"A clock is started at noon. By 10 minutes past 5, the hour hand has turned through:\",\n" +
            "            \"answer_a\": \"145°\",\n" +
            "            \"answer_b\": \"150°\",\n" +
            "            \"answer_c\": \"155°\",\n" +
            "            \"answer_d\": \"160°\",\n" +
            "            \"right_answer\": 3,\n" +
            "            \"selectedoption\": -1\n" +
            "          },\n" +
            "          {\n" +
            "            \"number\": \"15\",\n" +
            "            \"question\": \"The angle between the minute hand and the hour hand of a clock when the time is 4.20, is:\",\n" +
            "            \"answer_a\": \"0°\",\n" +
            "            \"answer_b\": \"10°\",\n" +
            "            \"answer_c\": \"5°\",\n" +
            "            \"answer_d\": \"20°\",\n" +
            "            \"right_answer\": 2,\n" +
            "            \"selectedoption\": -1\n" +
            "          },\n" +
            "          {\n" +
            "            \"number\": \"16\",\n" +
            "            \"question\": \"The angle between the minute hand and the hour hand of a clock when the time is 4.20, is:\",\n" +
            "            \"answer_a\": \"0°\",\n" +
            "            \"answer_b\": \"10°\",\n" +
            "            \"answer_c\": \"5°\",\n" +
            "            \"answer_d\": \"20°\",\n" +
            "            \"right_answer\": 2,\n" +
            "            \"selectedoption\": -1\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}"

}