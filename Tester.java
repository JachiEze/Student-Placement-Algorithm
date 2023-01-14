public class Tester
{
//Variable declaration
private int N, PairedCount;
private String[][] stPref;
private String[][] sPref;
private String[] students;
private String[] schools;
private String[] schoolAssigned;
private boolean[] studentPaired;

/* Constructor */
/* Initializing variables */
public Tester(String[] student, String[] school, String[][] stp, String[][]sp)
{
N = stp.length; 
this.PairedCount = 0;
this.students = student;
this.schools = school;
this.stPref = stp;
this.sPref = sp;
this.studentPaired = new boolean[N];
this.schoolAssigned = new String[N];
Matches();
}

/* The below function calculates all the matches */
private void Matches()
{
while (PairedCount < N)
{
int free;
for (free = 0; free < N; free++)
if (!studentPaired[free])
break;

for (int i = 0; i < N && !studentPaired[free]; i++)
{
int index = schoolIndex(stPref[free][i]);
if (schoolAssigned[index] == null)
{
schoolAssigned[index] = students[free]; 
studentPaired[free]= true;
PairedCount++;
}
else
{
String current = schoolAssigned[index];
if (Preference (current, students[free], index))
	
{
schoolAssigned [index] = students[free];
studentPaired[free]= true;
studentPaired [studentIndex(current)]  = false;
}
}
}
}
printPairs ();
}

//The below function checks whether a school prefers another potential student over the currently assigned student
private boolean Preference (String curOption, String newOption, int
index)
{
for (int i = 0; i < N; i++)
{
if (sPref[index][i].equals(newOption))
 return true;
if (sPref[index][i].equals(curOption)) 
return false;
}
return false;
}
//Student Index
private int studentIndex(String str)
{
for (int i = 0; i < N; i++)
if (students[i].equals (str))
return i;
return -1;
}

//School index
private int schoolIndex(String str)
{
for (int i = 0; i < N; i++)
if (schools[i].equals(str))
return i;
return -1;
}

//Print all the pairs
public void printPairs()
{
System.out.println("Pairs are : "); 
for (int i=0; i < N; i++)
{
System.out.println(schoolAssigned[i] +"->"+ schools[i]);
}
}
//Main method

public static void main(String[] args)
{
//List of students
String[] students =
{"Tom","Sara","Ali","Ying","Amit","Megan","Alan","Layla","Jane","Alex"};
//List of schools
String[] schools = 
{"UofO", "UofA", "OT", "UofT",
"UBC", "QU","YU", "CU", "MU", "UofW"};

//student preferences
String[][] student_preferences = {{"UBC", "UofT", "UofW", "UofA", "QU", "OT", "MU", "UofO", "YU", "CU"},
{"UofO", "QU", "UofT", "MU", "UofA", "UofW", "OT", "YU", "CU", "UBC"},   
{"QU", "UofT", "CU", "OT", "UofO", "MU", "UofA", "YU", "UBC", "UofW"},
{"MU", "OT", "UofA", "UBC", "QU", "CU", "UofW", "YU", "UofT", "UofO"}, 
{"UofT", "YU", "UofA", "OT", "UBC", "UofW", "QU", "UofO", "MU", "CU"},
{"YU", "UofW", "UBC", "UofT", "QU", "UofO", "MU", "OT", "CU", "UofA"}, 
{"MU", "YU", "CU", "UofO", "UofA", "UofT", "UBC", "QU", "OT", "UofW"},
{"UofT", "UofA", "MU", "CU", "YU", "UBC", "QU", "UofW", "OT", "UofO"},
{"OT", "UofO", "UofA", "MU", "YU", "UofT", "QU", "UBC", "UofW", "CU"},
{"UofW", "UofO", "OT", "MU", "YU", "UofT", "UBC", "CU", "QU", "UofA" }};


//school preferences
String[][] school_preferences = {{"Tom", "Alex", "Sara", "Jane", "Layla", "Ying", "Amit", "Alan", "Ali", "Megan"},
{"Ying", "Alex", "Megan", "Amit", "Sara", "Jane", "Tom", "Alan", "Layla", "Ali"},   
{"Alex", "Jane", "Megan", "Ying", "Sara", "Layla", "Ali", "Tom", "Amit", "Alan"},
{"Alan", "Amit", "Ying", "Megan", "Ali", "Sara", "Tom", "Alex", "Layla", "Jane"}, 
{"Tom", "Layla", "Alex", "Megan", "Jane", "Sara", "Ali", "Alan", "Ying", "Amit"},
{"Jane", "Sara", "Amit", "Tom", "Ali", "Alan", "Ying", "Layla", "Megan", "Alex"}, 
{"Sara", "Jane", "Alex", "Ying", "Ali", "Layla", "Alan", "Megan", "Tom", "Amit"},
{"Ying", "Tom", "Alan", "Layla", "Ali", "Megan", "Sara", "Amit", "Jane", "Alex"},
{"Tom", "Alan", "Layla", "Megan", "Sara", "Alex", "Jane", "Ali","Amit", "Ying"},
{"Jane", "Ali", "Amit", "Megan", "Layla", "Ying", "Tom", "Alex", "Sara", "Alan" }};

Tester gs = new Tester(students, schools, student_preferences, school_preferences);
}
}
