    JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class: 
	$(JC) $(JFLAGS) $*.java

CLASSES = SortVis.java AlgoChoice.java Bar.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class