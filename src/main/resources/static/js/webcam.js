$(function () {
        var w = 320, h = 240;
        var pos = 0, ctx = null, saveCB, image = [];

        var canvas = document.createElement("canvas");
        canvas.setAttribute('width', w);
        canvas.setAttribute('height', h);

        console.log(canvas.toDataURL);
        if (canvas.toDataURL) {

            ctx = canvas.getContext("2d");

            image = ctx.getImageData(0, 0, w, h);

            saveCB = function(data) {

                var col = data.split(";");
                var img = image;

                for(var i = 0; i < w; i++) {
                    var tmp = parseInt(col[i]);
                    img.data[pos + 0] = (tmp >> 16) & 0xff;
                    img.data[pos + 1] = (tmp >> 8) & 0xff;
                    img.data[pos + 2] = tmp & 0xff;
                    img.data[pos + 3] = 0xff;
                    pos+= 4;
                }

                if (pos >= 4 * w * h) {
                    ctx.putImageData(img, 0, 0);
                    $.post("${ctx}/common/webcam/uploadPhoto", {type: "data", image: canvas.toDataURL("image/png")}, function(msg){
                        console.log(msg);
                        pos = 0;
                        $("#img").attr("src", "${ctx}/"+msg);
                    });
                }
            };

        } else {

            saveCB = function(data) {
                image.push(data);

                pos+= 4 * w;

                if (pos >= 4 * w * h) {
                    $.post("${ctx}/common/webcam/uploadPhoto", {type: "pixel", image: image.join('|')}, function(msg){
                        console.log(msg);
                        pos = 0;
                        $("#img").attr("src", "${ctx}/"+msg);
                    });
                }
            };
        }

        $("#webcam").webcam({
            width: w,
            height: h,
            mode: "callback",
            swffile: "${ctxStatic }/jquery-plugin/jscam_canvas_only.swf",

            onSave: saveCB,

            onCapture: function () {
                webcam.save();
            },

            debug: function (type, string) {
                console.log(type + ": " + string);
            }
        });
    });

//拍照
function savePhoto(){
    webcam.capture();
}