package by.roman.shop.receiver;

import by.roman.shop.content.RequestContent;
import by.roman.shop.dao.DAOException;

import javax.sound.midi.Receiver;

public interface UserReceiver extends Receiver {
    /**
     * Sing up.
     *
     * @param content request content
     * @throws ReceiverException when throw DAOException
     *
     * @see DAOException
     * @see RequestContent
     */
    void signUp(RequestContent content) throws ReceiverException;

    /**
     * Sign in.
     *
     * @param content request content
     * @throws ReceiverException when throw DAOException
     *
     * @see DAOException
     * @see RequestContent
     */
    void signIn(RequestContent content) throws ReceiverException;

    /**
     * Sign out.
     *
     * @param content request content
     *
     * @see DAOException
     * @see RequestContent
     */
    void signOut(RequestContent content);

    /**
     * Open user setting.
     *
     * @param content request content
     * @throws ReceiverException when throw DAOException
     *
     * @see DAOException
     * @see RequestContent
     */

    void openProfile(RequestContent content) throws ReceiverException;

    /**
     * Change role.
     *
     * @param content request content
     * @throws ReceiverException when throw DAOException
     *
     * @see DAOException
     * @see RequestContent
     */
    void changeRole(RequestContent content) throws ReceiverException;

    /**
     * Change lock.
     *
     * @param content request content
     * @throws ReceiverException when throw DAOException
     *
     * @see DAOException
     * @see RequestContent
     */

}

