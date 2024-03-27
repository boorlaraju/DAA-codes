#include<iostream>
using namespace std;
int main()
{
    string a="rajuhirajuhirajuhi";
    string b="ujar";
    int flag;
    int count=0;
    for(int i=0;i<a.length()-b.length();i++)
    {
        if(a[i]==b[b.length()-1])
        {
            flag=0;
            for(int j=0;j<b.length();j++)
            {
                if(a[i+j]!=b[b.length()-1-j])
                {
                    flag=1;break;
                }
            }
        if(flag==0)
        {
            count++;
        cout<<"reverse of substring found in main string at index "<<i<<endl;
        }
        }
    }
    cout<<" count of reverse of substring in main string "<<count<<endl;
}