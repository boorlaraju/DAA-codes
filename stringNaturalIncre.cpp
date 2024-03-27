#include<iostream>
#include<math.h>
using namespace std;
int main()
{
    string a="defghijklmnop";
    string b="fhko";
    int flag;
    
    int count=0;
    for(int i=0;i<a.length()-(2*b.length()-1);i++)
    {
        if(b[0]==a[i])
        {
            flag=0;
                int k=1;
            for(int j=0;j<b.length();j++)
            {
                
                if(b[j]!=a[i+k])
                {
                    flag=1;
                    break;


                }
                i=j+i+1;
                
            
            }
            if(flag==0)
            {
                count++;
                cout<<"string matching found at "<<i<<endl;
            }
        }
    }
    cout<<"count string matching "<<count<<endl;
}