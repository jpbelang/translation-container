package ca.eloas.translets.container;

/**
 * @author JP
 */
public class ContainerException extends RuntimeException {
    public ContainerException(Exception e) {

            super(e);
    }

    public ContainerException(String s) {

        super(s);
    }
}
