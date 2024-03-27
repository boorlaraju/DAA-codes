#include<iostream>
#include<string.h>
using namespace std;
int main()
{
    string a="abbccdeffdefgh";
    string b="defg";
    int flag;
    int i;
    for( i=0;i<a.length()-b.length();i++)
    {

        if(b[0]==a[i])
        {
            flag=0;
            for(int j=0;j<b.length();j++)
            {
                if(a[j+i]!=b[j])
                {
                    flag=1;break;
                }
                
            }
            if(flag==0)
            {
                cout<<"string matching found at index "<<i<<endl;
            }
            
        }

        
    }
}