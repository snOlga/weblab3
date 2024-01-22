import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.faces.bean.SessionScoped;

public class ResponseList 
{
    private static ArrayList<Response> mainList = new ArrayList<Response>();

    public void add (Response item)
    {
        mainList.add(item);
    }

    public static ArrayList<Response> getMainList()
    {
        return mainList;
    }

    public static void setMainList(ArrayList<Response> mainList)
    {
        ResponseList.mainList = mainList;
    }

    public String getResponses()
    {
        String returnedLine = "";
        for(int i = 0; i < mainList.size(); i++)
        {
            returnedLine += mainList.get(i).getResponse() + " ";
        }
        return returnedLine;
    }
}
