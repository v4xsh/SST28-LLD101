public abstract class NotificationSender {
    protected final AuditLog audit;

    protected NotificationSender(AuditLog audit) {
        this.audit = audit;
    }

    /**
     * Base contract:
     * - Notification 'n' must not be null.
     */
    public final void send(Notification n) {
        if (n == null) {
            throw new IllegalArgumentException("notification cannot be null");
        }
        doSend(n);
    }

    protected abstract void doSend(Notification n);
}
