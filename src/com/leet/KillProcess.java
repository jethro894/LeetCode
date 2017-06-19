package com.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KillProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> pid = new ArrayList<Integer>();
		pid.add(1);
		pid.add(3);
		pid.add(10);
		pid.add(5);
		
		List<Integer> ppid = new ArrayList<Integer>();
		ppid.add(3);
		ppid.add(0);
		ppid.add(5);
		ppid.add(3);
		
		int kill = 5;
		
		System.out.println(new KillProcess().killProcess(pid, ppid, kill));
	}
	
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<Integer>();
		if(pid == null || ppid == null){
        	return res;
        }
		
		Map<Integer, Integer> idxToPid = new HashMap<Integer,Integer>();
		Map<Integer, List<Integer>> ppidToIdx = new HashMap<Integer,List<Integer>>();
		
		for(int i = 0; i < pid.size(); i++){
			idxToPid.put(i, pid.get(i));
		}
		for(int i = 0; i < ppid.size(); i++){
			if(ppidToIdx.containsKey(ppid.get(i))){
				ppidToIdx.get(ppid.get(i)).add(i);
			}else{
				List<Integer> indices = new ArrayList<Integer>();
				indices.add(i);
				ppidToIdx.put(ppid.get(i), indices);
			}
			
		}
		
		System.out.println(ppidToIdx);
		System.out.println(idxToPid);
		
		UnlimitedChildTreeNode root = new UnlimitedChildTreeNode(idxToPid.get(ppidToIdx.get(0).get(0)));
		Queue<UnlimitedChildTreeNode> queue = new LinkedList<UnlimitedChildTreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			UnlimitedChildTreeNode cur = queue.poll();
			
			List<Integer> children = ppidToIdx.get(cur.val);
			System.out.println(children);
			
			if(children != null){
				for(int i : children){
					UnlimitedChildTreeNode child = new UnlimitedChildTreeNode(idxToPid.get(i));
					cur.children.add(child);
					queue.add(child);
				}
			}
		}
		
		helper(root, kill, res, false);
		return res;
    }
	
	public void helper(UnlimitedChildTreeNode node, int kill, List<Integer> res, boolean include){
		if(node == null){
			return;
		}
		
		
		if(include || kill == node.val){
			include = true;
			res.add(node.val);
		}
		
		for(UnlimitedChildTreeNode child : node.children){
			helper(child, kill, res, include);
		}
	}
	
	public class UnlimitedChildTreeNode {
		int val;
		List<UnlimitedChildTreeNode> children;
		
		UnlimitedChildTreeNode(int val){
			this.val = val;
			this.children = new ArrayList<UnlimitedChildTreeNode>();
		}
	}

}
