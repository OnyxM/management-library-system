(function ($) {
    "use strict";
    var primarycolor = getComputedStyle(document.body).getPropertyValue('--primarycolor');
    var bordercolor = getComputedStyle(document.body).getPropertyValue('--bordercolor');
    var bodycolor = getComputedStyle(document.body).getPropertyValue('--bodycolor');

    var day_data = [
        {"period": "2019-09-15", "licensed": 3000},
        {"period": "2019-09-14", "licensed": 2357},
        {"period": "2019-09-13", "licensed": 2748},
        {"period": "2019-09-12", "licensed": 2471},
        {"period": "2019-09-11", "licensed": 2371},
        {"period": "2019-09-10", "licensed": 2201},
        {"period": "2019-09-09", "licensed": 1215}
    ];
    var week_statistics = document.getElementById("week_statistics");
    if (week_statistics) {
        var weekstats = Morris.Line({
            element: 'week_statistics',
            data: day_data,
            xkey: 'period',
            preUnits: '$',
            resize: true,
            lineColors: [primarycolor, '#7A92A3', '#4da74d', '#afd8f8', '#edc240', '#cb4b4b', '#9440ed'],
            ykeys: ['licensed'],
            labels: ['Sale']
        });
    }


    day_data = [
        {"period": "2019 W48", "licensed": 15407, "sorned": 660},
        {"period": "2019 W47", "licensed": 11407, "sorned": 660},
        {"period": "2019 W46", "licensed": 15407, "sorned": 660},
        {"period": "2019 W45", "licensed": 18407, "sorned": 660},
        {"period": "2019 W44", "licensed": 15407, "sorned": 660},
        {"period": "2019 W43", "licensed": 12407, "sorned": 660},
        {"period": "2019 W42", "licensed": 11407, "sorned": 660},
        {"period": "2019 W41", "licensed": 10407, "sorned": 660},
        {"period": "2019 W40", "licensed": 9407, "sorned": 660},
        {"period": "2019 W39", "licensed": 10407, "sorned": 660},
        {"period": "2019 W38", "licensed": 12407, "sorned": 660},
        {"period": "2019 W37", "licensed": 11407, "sorned": 660},
        {"period": "2019 W36", "licensed": 9407, "sorned": 660},
        {"period": "2019 W35", "licensed": 7407, "sorned": 660},
        {"period": "2019 W34", "licensed": 8407, "sorned": 660},
        {"period": "2019 W33", "licensed": 9407, "sorned": 660},
        {"period": "2019 W32", "licensed": 8407, "sorned": 660},
        {"period": "2019 W31", "licensed": 7407, "sorned": 660},
        {"period": "2019 W30", "licensed": 6407, "sorned": 660},
        {"period": "2019 W29", "licensed": 5407, "sorned": 660},
        {"period": "2019 W28", "licensed": 4407, "sorned": 660},
        {"period": "2019 W27", "licensed": 3407, "sorned": 660},
        {"period": "2019 W26", "licensed": 3351, "sorned": 629},
        {"period": "2019 W25", "licensed": 3269, "sorned": 618},
        {"period": "2019 W24", "licensed": 3246, "sorned": 661},
        {"period": "2019 W23", "licensed": 3257, "sorned": 667},
        {"period": "2019 W22", "licensed": 3248, "sorned": 627},
        {"period": "2019 W21", "licensed": 3171, "sorned": 660},
        {"period": "2019 W20", "licensed": 3171, "sorned": 676},
        {"period": "2019 W19", "licensed": 3201, "sorned": 656},
        {"period": "2019 W18", "licensed": 3215, "sorned": 622},
        {"period": "2019 W17", "licensed": 3148, "sorned": 632},
        {"period": "2019 W16", "licensed": 3155, "sorned": 681},
        {"period": "2019 W15", "licensed": 3190, "sorned": 667},
        {"period": "2019 W14", "licensed": 3226, "sorned": 620},
        {"period": "2019 W13", "licensed": 3245, "sorned": null},
        {"period": "2019 W12", "licensed": 3289, "sorned": null},
        {"period": "2019 W11", "licensed": 3263, "sorned": null},
        {"period": "2019 W10", "licensed": 3189, "sorned": null},
        {"period": "2019 W09", "licensed": 3079, "sorned": null},
        {"period": "2019 W08", "licensed": 3085, "sorned": null},
        {"period": "2019 W07", "licensed": 3055, "sorned": null},
        {"period": "2019 W06", "licensed": 3063, "sorned": null},
        {"period": "2019 W05", "licensed": 2943, "sorned": null},
        {"period": "2019 W04", "licensed": 2806, "sorned": null},
        {"period": "2019 W03", "licensed": 2674, "sorned": null},
        {"period": "2019 W02", "licensed": 1702, "sorned": null},
        {"period": "2019 W01", "licensed": 1732, "sorned": null}
    ];
    var month_statistics = document.getElementById("month_statistics");
    if (month_statistics) {
        var monthstats = Morris.Line({
            element: 'month_statistics',
            data: day_data,
            xkey: 'period',
            resize: true,
            padding: 15,
            preUnits: '$',
            lineColors: [primarycolor, '#7A92A3', '#4da74d', '#afd8f8', '#edc240', '#cb4b4b', '#9440ed'],
            ykeys: ['licensed'],
            labels: ['Sale']
        });
    }
    day_data = [
        {"period": "2019", "licensed": 14246},
        {"period": "2018", "licensed": 11257},
        {"period": "2017", "licensed": 12248},
        {"period": "2016", "licensed": 9171},
        {"period": "2015", "licensed": 7171},
        {"period": "2014", "licensed": 5201},
        {"period": "2013", "licensed": 3215}
    ];
    var year_statistics = document.getElementById("year_statistics");
    if (year_statistics) {
        var yearstats = Morris.Line({
            element: 'year_statistics',
            data: day_data,
            xkey: 'period',
            resize: true,
            padding: 15,
            preUnits: '$',
            lineColors: [primarycolor, '#7A92A3', '#4da74d', '#afd8f8', '#edc240', '#cb4b4b', '#9440ed'],
            ykeys: ['licensed'],
            labels: ['Sale']
        });
    }
    $('a[data-toggle="pill"]').on('shown.bs.tab', function (e) {
        var target = $(e.target).attr("href") // activated tab

        switch (target) {
            case "#pills-week":
                if (week_statistics) {
                    weekstats.redraw();
                }
                $(window).trigger('resize');
                break;
            case "#pills-month":
                if (month_statistics) {
                    monthstats.redraw();
                }
                $(window).trigger('resize');
                break;
            case "#pills-year":
                if (year_statistics) {
                    yearstats.redraw();
                }
                $(window).trigger('resize');
                break;
        }
    });

    ////////////////////////////////// Line Basic //////////////////////////////
    var config = {
        type: 'line',
        data: {
            labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'Aug'],
            datasets: [{
                    label: 'My First dataset',
                    backgroundColor: primarycolor,
                    borderColor: primarycolor,
                    data: [0, 66, 90, 55, 65, 58, 97, 30],
                    fill: false,
                }]
        },
        options: {
            responsive: true,
            legend: {
                position: 'top',
                display: false,
                labels: {
                    fontColor: bodycolor
                }
            },
            tooltips: {
                mode: 'index',
                intersect: false,
            },
            hover: {
                mode: 'nearest',
                intersect: true
            },
            scales: {
                xAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true
                        },
                        gridLines: {
                            display: true,
                            color: bordercolor,
                            zeroLineColor: bordercolor
                        },
                        ticks: {
                            fontColor: bodycolor,

                        }
                    }],
                yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true
                        },
                        gridLines: {
                            display: true,
                            color: bordercolor,
                            zeroLineColor: bordercolor
                        },
                        ticks: {
                            fontColor: bodycolor,

                        }
                    }]
            }
        }
    };

    var chartjs_line_basic = document.getElementById("chartjs-line-basic");
    if (chartjs_line_basic) {
        var ctx = document.getElementById('chartjs-line-basic').getContext('2d');
        window.myLine = new Chart(ctx, config);
    }

    ////////////////////////////////////// Area Chart Boundries /////////////////
    var chartjs_area_boundaries = document.getElementById("chartjs-area-boundary");
    if (chartjs_area_boundaries) {

        var config = {

            elements: {
                line: {
                    tension: 0.000001
                }
            },
            plugins: {
                filler: {
                    propagate: false
                }
            },
            legend: {
                display: false,
                position: 'top',
                labels: {
                    fontColor: bodycolor
                }
            },

            scales: {
                x: {
                    ticks: {
                        autoSkip: false,
                        maxRotation: 0
                    }
                },
                xAxes: [{
                        display: true,
                        gridLines: {
                            display: true,
                            color: bordercolor,
                            zeroLineColor: bordercolor
                        },
                        ticks: {
                            fontColor: bodycolor,

                        },
                    }],
                yAxes: [{
                        display: true,
                        gridLines: {
                            display: true,
                            color: bordercolor,
                            zeroLineColor: bordercolor
                        },
                        ticks: {
                            fontColor: bodycolor,

                        }
                    }]

            }
        };


        new Chart('chartjs-area-boundary', {
            type: 'line',
            data: {
                labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                datasets: [{
                        backgroundColor: 'rgba(163, 85, 255, 0.4)',
                        borderColor: primarycolor,
                        data: [20, 66, 90, 55, 65, 58, 97],
                        label: 'Dataset',
                        fill: 'start'
                    }]
            },
            options: Chart.helpers.merge(config)
        });

    }





    var gdpData = {
        "AF": 16.63,
        "AL": 11.58,
        "DZ": 158.97,
        "AO": 85.81,
        "AG": 1.1,
        "AR": 351.02,
        "AM": 8.83,
        "AU": 1219.72,
        "AT": 366.26,
        "AZ": 52.17,
        "BS": 7.54,
        "BH": 21.73,
        "BD": 105.4,
        "BB": 3.96,
        "BY": 52.89,
        "BE": 461.33,
        "BZ": 1.43,
        "BJ": 6.49,
        "BT": 1.4,
        "BO": 19.18,
        "BA": 16.2,
        "BW": 12.5,
        "BR": 2023.53,
        "BN": 11.96,
        "BG": 44.84,
        "BF": 8.67,
        "BI": 1.47,
        "KH": 11.36,
        "CM": 21.88,
        "CA": 1563.66,
        "CV": 1.57,
        "CF": 2.11,
        "TD": 7.59,
        "CL": 199.18,
        "CN": 5745.13,
        "CO": 283.11,
        "KM": 0.56,
        "CD": 12.6,
        "CG": 11.88,
        "CR": 35.02,
        "CI": 22.38,
        "HR": 59.92,
        "CY": 22.75,
        "CZ": 195.23,
        "DK": 304.56,
        "DJ": 1.14,
        "DM": 0.38,
        "DO": 50.87,
        "EC": 61.49,
        "EG": 216.83,
        "SV": 21.8,
        "GQ": 14.55,
        "ER": 2.25,
        "EE": 19.22,
        "ET": 30.94,
        "FJ": 3.15,
        "FI": 231.98,
        "FR": 2555.44,
        "GA": 12.56,
        "GM": 1.04,
        "GE": 11.23,
        "DE": 3305.9,
        "GH": 18.06,
        "GR": 305.01,
        "GD": 0.65,
        "GT": 40.77,
        "GN": 4.34,
        "GW": 0.83,
        "GY": 2.2,
        "HT": 6.5,
        "HN": 15.34,
        "HK": 226.49,
        "HU": 132.28,
        "IS": 12.77,
        "IN": 1430.02,
        "ID": 695.06,
        "IR": 337.9,
        "IQ": 84.14,
        "IE": 204.14,
        "IL": 201.25,
        "IT": 2036.69,
        "JM": 13.74,
        "JP": 5390.9,
        "JO": 27.13,
        "KZ": 129.76,
        "KE": 32.42,
        "KI": 0.15,
        "KR": 986.26,
        "UNDEFINED": 5.73,
        "KW": 117.32,
        "KG": 4.44,
        "LA": 6.34,
        "LV": 23.39,
        "LB": 39.15,
        "LS": 1.8,
        "LR": 0.98,
        "LY": 77.91,
        "LT": 35.73,
        "LU": 52.43,
        "MK": 9.58,
        "MG": 8.33,
        "MW": 5.04,
        "MY": 218.95,
        "MV": 1.43,
        "ML": 9.08,
        "MT": 7.8,
        "MR": 3.49,
        "MU": 9.43,
        "MX": 1004.04,
        "MD": 5.36,
        "MN": 5.81,
        "ME": 3.88,
        "MA": 91.7,
        "MZ": 10.21,
        "MM": 35.65,
        "NA": 11.45,
        "NP": 15.11,
        "NL": 770.31,
        "NZ": 138,
        "NI": 6.38,
        "NE": 5.6,
        "NG": 206.66,
        "NO": 413.51,
        "OM": 53.78,
        "PK": 174.79,
        "PA": 27.2,
        "PG": 8.81,
        "PY": 17.17,
        "PE": 153.55,
        "PH": 189.06,
        "PL": 438.88,
        "PT": 223.7,
        "QA": 126.52,
        "RO": 158.39,
        "RU": 1476.91,
        "RW": 5.69,
        "WS": 0.55,
        "ST": 0.19,
        "SA": 434.44,
        "SN": 12.66,
        "RS": 38.92,
        "SC": 0.92,
        "SL": 1.9,
        "SG": 217.38,
        "SK": 86.26,
        "SI": 46.44,
        "SB": 0.67,
        "ZA": 354.41,
        "ES": 1374.78,
        "LK": 48.24,
        "KN": 0.56,
        "LC": 1,
        "VC": 0.58,
        "SD": 65.93,
        "SR": 3.3,
        "SZ": 3.17,
        "SE": 444.59,
        "CH": 522.44,
        "SY": 59.63,
        "TW": 426.98,
        "TJ": 5.58,
        "TZ": 22.43,
        "TH": 312.61,
        "TL": 0.62,
        "TG": 3.07,
        "TO": 0.3,
        "TT": 21.2,
        "TN": 43.86,
        "TR": 729.05,
        "TM": 0,
        "UG": 17.12,
        "UA": 136.56,
        "AE": 239.65,
        "GB": 2258.57,
        "US": 14624.18,
        "UY": 40.71,
        "UZ": 37.72,
        "VU": 0.72,
        "VE": 285.21,
        "VN": 101.99,
        "YE": 30.02,
        "ZM": 15.69,
        "ZW": 5.57
    };


    //////////////////// World Map  /////////////////////
    $('#world-map-gdp').vectorMap({
        map: 'world_mill',
        backgroundColor: 'transparent',
        series: {
            regions: [{
                    values: gdpData,
                    scale: ['#ccc', '#ccc'],
                    normalizeFunction: 'polynomial'
                }]
        },
        onRegionTipShow: function (e, el, code) {
            el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
        }
    });

})(jQuery);
