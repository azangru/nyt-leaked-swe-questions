

//Defaults
let launch_url = 'https://cooking.nytimes.com';



let nightwatch_config = {
    'src_folders': ['tests'],
    'output_folder': 'test-reports',
    'page_objects_path': ['pages'],
    'globals_path': './globals.js',
    'test_workers': {
        'enabled': false,
        'workers': 'auto'
    },

    'selenium': {
        'start_process': true,
        'server_path': 'selenium-server-standalone-3.4.0.jar',
        'log_path': 'test-reports',
        'cli_args': {
            'webdriver.chrome.driver': 'chromedriver'
        }
    },

    'test_settings': {
        'default': {
            'launch_url': launch_url,
            'selenium_host': 'localhost',
            'selenium_port': 4444,
            'skip_testcases_on_fail': false,
            'desiredCapabilities': {
                'browserName': 'chrome',
                'platform': 'MAC',
                'javascriptEnabled': true,
                'acceptSslCerts': true,

            }
        }
    }
};

module.exports = nightwatch_config;
