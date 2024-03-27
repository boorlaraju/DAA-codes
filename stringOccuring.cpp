#include<iostream>
using namespace std;
int main()
{
    string a="rajuhirajuhirajuhi";
    string b="raju";
    int count=0;
    int flag;
    int i,j;
    for(i=0;i<a.length();i++)
    {
        if(b[0]==a[i])
        {
            flag=0;
            for(j=0;j<b.length();j++)
            {
                if(b[j]!=a[i+j])
                {
                    flag=1;break;
                    
                }
                
            }
            count++;
        }
    }
    cout<<"substring found "<<count<<" times"<<endl;
}