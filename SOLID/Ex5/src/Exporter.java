public abstract class Exporter {
    /**
     * Base contract:
     * - req must not be null
     * - returns non-null ExportResult
     * - throws IllegalArgumentException for format-specific limits
     */
    public final ExportResult export(ExportRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("request cannot be null");
        }
        return doExport(req);
    }

    protected abstract ExportResult doExport(ExportRequest req);
}
