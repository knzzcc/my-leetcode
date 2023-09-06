private void merge(int[] nums, int lo, int mid, int hi){
    for(int i=0;i<=hi;i++) temp[i]= nums[i];
    int cnt = lo;
    int i = lo, j = mid+1;
    whiel(i<=mid||j<=hi){
        if(i>mid) nums[cnt++]=tmp[j++];
        else if(j>hi)nums[cnt++]=tmp[i++];
        else if(temp[i]<=temp[j])nums[cnt++]=temp[i++];
        else nums[cnt++] = temp[j++];
    }
}

private void merge(int[] nums, int lo, int mid, int hi){
    for(int i=0;i<=hi;i++)temp[i]=nums[i];
    int cnt=lo;
    int i=lo;j=mid+1;
    while(i<=mid||j<=hi){
        if(i>mid)nums[cnt++]=tempt[i++];
        
    }
}