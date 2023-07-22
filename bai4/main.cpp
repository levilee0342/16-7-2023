#include <iostream>
using namespace std;
int fact(int num);
int main()
{
      int n, r, npr_var;
  
    cin>>r;
    cin>>n;
     
    npr_var = fact(n) / fact(n - r);
    cout<<npr_var;
}
int fact(int num)
{
    int k = 1, i;
    if (num == 0)
    {
        return(k);
    }
    else
    {
        for (i = 1; i <= num; i++)
    {
            k = k * i;
    }
    }
    return(k);
}
