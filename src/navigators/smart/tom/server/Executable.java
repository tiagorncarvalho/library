package navigators.smart.tom.server;

import navigators.smart.tom.MessageContext;

/**
 * 
 * @author mhsantos
 *
 */
public interface Executable {

    /**
     * Method called to execute a request totally ordered.
     * 
     * The message context contains a lot of information about the request, such
     * as timestamp, nonces and sender. The code for this method MUST use the value
     * of timestamp instead of relying on its own local clock, and nonces instead
     * of trying to generated its own random values.
     * 
     * This is important because this values are the same for all replicas, and
     * therefore, ensure the determinism required in a replicated state machine.
     *
     * @param command the command issue by the client
     * @param msgCtx information related with the command
     * 
     * @return the reply for the request issued by the client
     */
    public byte[] executeOrdered(byte[] command, MessageContext msgCtx);

    /**
     * Method called to execute a request totally ordered.
     * 
     * The message context contains some useful information such as the command
     * sender.
     * 
     * @param command the command issue by the client
     * @param msgCtx information related with the command
     * 
     * @return the reply for the request issued by the client
     */
    public byte[] executeUnordered(byte[] command, MessageContext msgCtx);
}