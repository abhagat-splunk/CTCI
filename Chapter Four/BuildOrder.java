import java.util.*;
class Project{
	private ArrayList<Project> children = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String,Project>();
	private String name;
	private int dependencies;

	Project(String n){
		this.name = n;
	}
	public String getName(){
		return name;
	}

	public void addDependencies(){
		dependencies+=1;
	}
	public void subDependencies(){
		dependencies-=1;
	}

	public ArrayList<Project> getChildren(){
		return children;
	}

	public int getDependencies(){
		return dependencies;
	}

	public void addNeighbour(Project node){
		if(!map.containsKey(node.getName())){
			children.add(node);
			map.put(node.getName(),node);
			node.addDependencies();
		}
	}

}

class Graph{
	private ArrayList<Project> nodes = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String,Project>();

	public Project getOrCreateNode(String name){
		if(!map.containsKey(name)){
			Project node = new Project(name);
			nodes.add(node);
			map.put(name,node);
			return node;
		}
		return map.get(name);
	}

	public void AddEdge(String startname, String endname){
		Project start = map.get(startname);
		Project end = map.get(endname);
		start.addNeighbour(end);
	}

	public ArrayList<Project> getNodes(){
		return nodes;
	}
}

class BuildOrder{
	public static Graph buildGraph(String[] projects, String[][] dependencies){
		Graph graph = new Graph();
		for (String project:projects){
			graph.getOrCreateNode(project);
		}
		for(String[] dependency: dependencies){
			String first = dependency[0];
			String second = dependency[1];
			graph.AddEdge(first,second);
		}
		return graph;
	}

	public static Project[] findBuildOrder(String[] projects, String[][] dependencies){
		Graph graph = buildGraph(projects,dependencies);
		return orderProjects(graph.getNodes());
	}

	public static Project[] orderProjects(ArrayList<Project> projects){
		Project[] order = new Project[projects.size()];
		int endOfList = addNonDependent(order,projects,0);
		int toBeProcessed = 0;
		while(toBeProcessed<order.length){
			Project current = order[toBeProcessed];
			//System.out.println(current.getName());
			if(current==null){
				return null;
			}
			ArrayList<Project> children = current.getChildren();
			for(Project p: children){
				p.subDependencies();
			}

			endOfList = addNonDependent(order,projects,endOfList);
			toBeProcessed+=1;
		}
		return order;
}


	public static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset){
		for(Project project:projects){
			//System.out.println(project.getName());
			if(project.getDependencies()==0){
				if(!Arrays.asList(order).contains(project)){
					order[offset] = project;
					offset++;
				}
			}
		}
		return offset;
	}

	public static void main(String args[]){
		String[][] dependencies = {{"F","C"},{"F","B"},{"C","A"},{"B","A"},{"F","A"},{"A","E"},{"B","E"},{"D","G"}};
		String[] projectNames = {"A","B","C","D","E","F","G"};
		Project[] result = findBuildOrder(projectNames,dependencies);
		//System.out.println(result);
		for(Project r: result){
			System.out.println(r.getName());
		}
	}
}