WireMockServer wireMockServer = new WireMockServer(WireMockServerConfig.options()
        .port(8089)
        .notifier(new SLF4JNotifier(true))
        .usingJaxbForResponse());
