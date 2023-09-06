private List<Integer> getPrime(int n){
    List<Integer> ans = new ArrayList<>();
    boolean[] vis = new boolean[n+1];
    for(int i=2;i<=n;i++){
        if(!vis[i]){
            ans.add(i);
            vis[i]=true;
        }
        for(int j=0;j<ans.size();j++){
            int cur = ans.get(j);
            if(i*cur>n)break;
            visit[i*cur]=true;
            if(i%cur==0)break;
        }
    }

    return ans;
}