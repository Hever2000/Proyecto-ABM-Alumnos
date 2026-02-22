(() => {
    const STORAGE_KEY = "apiBaseUrl";
    const saved = localStorage.getItem(STORAGE_KEY);
    const meta = document.querySelector('meta[name="api-base-url"]')?.content;
    const isLocalhost = window.location.hostname === "localhost" || window.location.hostname === "127.0.0.1";
    const defaultLocalApi = "http://localhost:8080/api";

    const baseUrl = (meta || saved || (isLocalhost ? defaultLocalApi : "")).replace(/\/+$/, "");

    window.API_BASE_URL = baseUrl;
    window.getApiUrl = (path) => {
        if (!window.API_BASE_URL) {
            throw new Error("API base URL no configurada. Define localStorage.apiBaseUrl o meta[name='api-base-url'].");
        }

        const normalizedPath = path.startsWith("/") ? path : `/${path}`;
        return `${window.API_BASE_URL}${normalizedPath}`;
    };
})();
