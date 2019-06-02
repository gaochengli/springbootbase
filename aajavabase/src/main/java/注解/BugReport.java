/**
 * 
 */
package 注解;

/**
 * @author clgao
 *
 */
public abstract @interface BugReport {
	String assignedTo() default "[none]";
	int severity();
	enum Status {UNCONFIRMED,CONFIRMED,FIXED,NOTABUG};
	boolean showStopper() default false;
	Class<?> testCase() default Void.class;
	Status status() default Status.UNCONFIRMED;
	GcclAnnotation ref() default @GcclAnnotation();
	String[] reportedBy();
}

