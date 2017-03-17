class StatusController {
    constructor() {
        this.voltage = $("#voltage-label");
        this.amperage = $("#amperage-lable");
        this.charge = $(".progress-bar");
        this.pressure = $("#presure-lable");
        this.humidity = $("#hummidity-lable");
        this.temperature_cpu = $("#cputemp-lable");
        this.temperature_hull = $("#insidetemp-lable");
    }

    setProperty(propName, value) {
        if (propName == "charge") {
            this.setBattery(value);
            return;
        }
        this[propName].text(value);
    };

    setBattery(value) {
        this.charge.css("width", value + "%");
        this.charge.text(value + "%");
    };

    setProperties(props) {
        for (let p  in props) {
            this.setProperty(p, props[p]);

        }
    };

    update() {
        let self = this;
        $.get("/status", function (data) {
            self.setProperties(data);
        });
        setTimeout(function () {
            self.update();
        }, 1000);
    }
}

class LogsController {

    constructor() {
        let self = this;

        this.logTextArea = $("#log-text-area");
        this.elem = $("#log-links");
        this.elem.html("");
        $.get("/journals", function (data) {
            let logs = data["journals"];
            console.log(logs);
            for (let l in logs) {
                $("#log-links").append($("<a class='logItem' href='/journal?name=" + logs[l] + "'>" + logs[l] + "</a>"));
            }
        });
        this.elem.click(function (e) {
            e.preventDefault();

            let href = $(e.target).attr("href");
            console.log(href);
            self.showLog(href);

            return false;
        });



        //console.log(LogsController.prototype)
    }

    updateLogs() {

    }

    showLog(logPath) {
        let that = this;
        $.get(logPath, function (data) {
            let logs = data["journal"];
            for (let l in logs) {
                that.logTextArea.append($("<div class='log-item'>" + logs[l] + "</div>"));
            }
        })
    }
}

class HelmController{
    constructor(){
        let self = this;
        $.get("/helm", function (data) {
            for (let d in data){
                let elem = $("#"+d).text(data[d]);
            }
        })
    }
}
class DataBase{
    constructor(){
        $.get("/database", function (data) {
            for (let d in data){
                let elem = $("#"+d).text(data[d]);
            }
        });

    }
}