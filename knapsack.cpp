#include<iostream>
#include<math.h>
using namespace std;
int knap_sack(int n,int w,int wt[],int val[])
{
    if(n==0 || w==0)
    {
        return 0;
    }
    if(wt[n-1]<=w)
    {
        return max(  (val[n-1]  +  knap_sack(n-1, w-wt[n-1] ,wt , val)), knap_sack(n-1, w ,wt , val));
        
    }
    else
    {
        return knap_sack(n-1,w,wt,val);
    }
}
int main()
{
    int wt[5]={5,3,2,9,6};
    int val[5]={7,10,15,18,24};
    int value=knap_sack(5,17,wt,val);
    cout<<value<<endl;
    

    
}