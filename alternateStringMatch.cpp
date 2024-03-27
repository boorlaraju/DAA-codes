#include<iostream>
using namespace std;
int main()
{
    string a="defghijklmop";
    string b="fhjl";
    int flag;
    
    int count=0;
    for(int i=0;i<a.length()-(2*b.length()-1);i++)
    {
        if(b[0]==a[i])
        {
            flag=0;
                int k=0;
            for(int j=0;j<b.length();j++)
            {
                
                if(b[j]!=a[i+j+k])
                {
                    flag=1;
                    //cout<<i+j+k<<endl;
                    break;


                }
                k=k+1;
            
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