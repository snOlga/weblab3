import jakarta.persistence.*;

@Entity
@Table(name = "response")
public class Response
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "x")
    private float x;
    @Column(name = "y")
    private float y;
    @Column(name = "r")
    private float r;
    @Column(name = "resp")
    private boolean value;

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public float getR()
    {
        return r;
    }

    public int getID()
    {
        return id;
    }

    public boolean isValue()
    {
        return value;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void setR(float r)
    {
        this.r = r;
    }

    public void setValue(boolean value)
    {
        this.value = value;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Response()
    {

    }

    public Response(float xValue, float yValue, float rValue)
    {
        this.x = xValue;
        this.y = yValue;
        this.r = rValue;
    }

    public boolean calculate()
    {
        if(x==0 && y==0)
        {
            value = true;
        }

        if((x <= 0 && x >= (0-(r/2))) && (y <= (2*x + r) && y >= 0))
        {
            value = true;
        } 
        else if((x > 0 && x <= (r/2)) && (y < 0 && y >= (0-r)))
        {
            value = true;
        }
        else if((x > 0 && x <= (r/2)) && (y >= 0 && y <= r/2) && (y <= (Math.sqrt(r*r - x*x))))
        {
            value = true;
        }
        else
        {
            value = false;
        }
        return value;
    }

    public String getResponse()
    {
        return Boolean.toString(calculate());
    }


    @Override
    public boolean equals(Object obj)
    {
        if(this.id == ((Response) obj).getID())
        {
            return true;
        }
        return false;
    }
}
