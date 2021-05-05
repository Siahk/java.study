package tool;

public class test
{
    public static void main(String[] args) {
        var ext = new ext();

        int dd = 9;
        double ddd = (double)dd;

        if(ext instanceof base)
        {
            System.out.println("true");
        }

        Do(ext);
    }

    public static void Do(inter b)
    {
        b.Do();
    }
}

interface iter{
    void Do();
}

// /**
//  * Innertest
//  */
// abstract class base extends iter {

//     public abstract void Do();

//     public int Add(int i)
//     {
//         i++;
//     }
// }

/**
 * ext
 */
class ext {

    public void Dooo()
    {

    }

    public void Do()
    {
        System.out.println("ext");
    }
}


class ext2
{
    public void Do()
    {
        System.out.println("ext");
    }
}

// 里氏替换原则