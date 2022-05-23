package fourth.laboratoy.exam.pripremni;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class JavaProjectFileVisitor extends SimpleFileVisitor<Path> {
	private Set<String> extensionFilter;
	private Map<String, Set<Path>> map = new HashMap<>();

	public JavaProjectFileVisitor(Set<String> extensionFilter) {
		this.extensionFilter = extensionFilter;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		int index = file.getFileName().toString().lastIndexOf(".");
		String s = file.getFileName().toString().substring(index);
		// s = filextension
		
		boolean check = true;
		for (String a : extensionFilter) {
			if (a.equals(s))
				check = false;
		}
		if (check) {
			if (!map.containsKey(s))
				map.put(s, new HashSet<Path>());

		map.get(s).add(file);
		}
		return FileVisitResult.CONTINUE;
	}

	public Map<String, Set<Path>> getProjectPathsPerExtension() {
		return map;
	}
}
//	JavaProjectFileVisitor visitor = new JavaProjectFileVisitor(Set.of(".pdf"));
//	File f = new File("folder1");
//	Files.walkFileTree(f.toPath(), visitor);
//	Map<String, Set<Path>> map = visitor.getProjectPathsPerExtension();
//	for(String key : map.keySet()) {
//	  Set<Path> list = map.get(key);
//	  for(Path p : list)
//	    System.out.println("Key: " + key + " - " + p);


//	private Map<String, Long> map = new HashMap<>();
//	
//	public JavaProjectFileVisitor() {
//		super();
//	}
//	
//	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//		int index = file.getFileName().toString().lastIndexOf(".");
//		String s = file.getFileName().toString().substring(index);
//		
//		Long currentSize = map.getOrDefault(s, (long) 0);
//		map.put(s, attrs.size() + currentSize);
//		return FileVisitResult.CONTINUE;		
//	}
////	JavaProjectFileVisitor visitor = new JavaProjectFileVisitor();
////	File f = new File("folder1");
////	Files.walkFileTree(f.toPath(), visitor);
////	Map<String, Long> map = visitor.getProjectFileSizeInfo();
////	for(String key : map.keySet())
////	    System.out.println("Key: " + key + " - " + map.get(key));
//	
//	
//	public Map<String, Long> getProjectFileSizeInfo() {
//		return map;
//	}
//}
