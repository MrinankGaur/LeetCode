import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> emailToIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, i);
                } else {
                    ds.unionBySize(i, emailToIndex.get(email));
                }
            }
        }

        ArrayList<ArrayList<String>> mergedMail = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mergedMail.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> entry : emailToIndex.entrySet()) {
            String email = entry.getKey();
            int parent = ds.findUParent(entry.getValue());
            mergedMail.get(parent).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail.get(i).size() == 0) continue;
            Collections.sort(mergedMail.get(i));
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(accounts.get(i).get(0));
            mergedAccount.addAll(mergedMail.get(i));
            result.add(mergedAccount);
        }

        return result;
    }
}

class DisjointSet {
    List<Integer> parent, size;

    public DisjointSet(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUParent(int node) {
        if (parent.get(node) == node) return node;
        int root = findUParent(parent.get(node));
        parent.set(node, root);
        return root;
    }

    public void unionBySize(int u, int v) {
        int pu = findUParent(u);
        int pv = findUParent(v);
        if (pu == pv) return;

        if (size.get(pu) < size.get(pv)) {
            parent.set(pu, pv);
            size.set(pv, size.get(pv) + size.get(pu));
        } else {
            parent.set(pv, pu);
            size.set(pu, size.get(pv) + size.get(pu));
        }
    }
}
