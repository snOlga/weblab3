import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

@Named(value="controller")
@ApplicationScoped
public class Controller {

    //NORMAL-----------------------------------------
        public String getTime()
    {
        LocalTime time = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return time.format(timeFormatter);
    }

    private final int maxXSize = 3;

    public String getRandomX()
    {
        Random random = new Random();
        int randomNum = random.nextInt(maxXSize + 1);
        int randomSign = random.nextInt(2);

        //1 is for plus
        //0 is for minus
        if(randomSign == 1)
        {
        } else
        {
            randomNum *= -1;
        }
        xValue = randomNum;
        return "" + randomNum;
    }
    //NORMAL-----------------------------------------

    private boolean xValueBool = false;

    public void setxValueBool(boolean xValue) {
        this.xValueBool = xValue;
    }
    public boolean getxValueBool()
    {
        return xValueBool;
    }

    private static float xValue = 0;
    public float getxValue() {
        return xValue;
    }
    public void setxValue(float xValue) {
        System.out.println(xValue);
        this.xValue = xValue;
    }

    //NORMAL-----------------------------------------
    private static float yValue = 0;

    public float getyValue() {
        return yValue;
    }
    public void setyValue(float yValue) {
        System.out.println(yValue);
        this.yValue = yValue;
    }
    //NORMAL-----------------------------------------

    private static float rValue = 3;
    public void setrValue(float rValue) {
        this.rValue = rValue;
    }
    public float getrValue() {
        return rValue;
    }

    //NORMAL-----------------------------------------

    private static ArrayList<Response> responseList = new ArrayList<>();

    public void setResponseList(ArrayList<Response> responseList)
    {
        this.responseList = responseList;
    }

    public ArrayList<Response> getResponseList()
    {
        return responseList;
    }

    //NORMAL-----------------------------------------

    public String getResponse()
    {
        if(xValueBool && rValue <= 3 && rValue >= 0)
        {
            Response response = new Response(xValue, yValue, rValue);
            ResponseList responseList = new ResponseList();

            responseList.add(response);
            this.responseList = responseList.getMainList();

            DataBaseModule.writeToDB(response);

            return (responseList.getResponses());
        }
        return "";
    }

    public String startScript()
    {
        ResponseList responseList = new ResponseList();
        responseList.setMainList((ArrayList<Response>) DataBaseModule.getFromDBList());
        return "";
    }
}
