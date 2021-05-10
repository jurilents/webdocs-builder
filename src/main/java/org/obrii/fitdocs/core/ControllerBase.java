package org.obrii.fitdocs.core;

public abstract class ControllerBase {

    protected String badRequest400() {
        return this.errorRedirect(400, "Bad request.");
    }

    protected String unauthorized401() {
        return this.errorRedirect(403, "Access denied.");
    }

    protected String forbidden403() {
        return this.errorRedirect(403, "Forbidden.");
    }

    protected String notFound404() {
        return this.errorRedirect(404, "Not found.");
    }

    private String errorRedirect(int code, String message) {
        return String.format("redirect:/error?code=%d&msg=%s", code, message);
    }
}
