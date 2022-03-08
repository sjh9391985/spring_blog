let index = {
    init : function() {
        $("#btn-save").on("click", () => {
            this.save();
        });

        $("#btn-delete").on("click", () => {
            this.deleteById();
        });

    },

    save: function(){
        //alert("!!")
        let data = {
            title : $("#title").val(),
            content : $("#content").val(),
        };

        //ajax 호출시 default가 비동기 호출.
        $.ajax({
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data),// json 문자열로 실행이 됩니다.
            contentType: "application/json; charset=utf-8", // body 데이터가 어떤 타입인지(MIME)
            dataType: "json", // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(String) 인데 모양이 json 이라면 JS 오브젝트로 변경을 해줍니다.
            }).done(function(response){
                alert("글등록 완료되었습니다.");
                location.href = "/";
            }).fail(function(error){
                alert(JSON.stringify(error));
            }); // ajax 통신을 통해서 3개의 데이터를 json으로 변경하여 insert 호출을 할 예졍
        },
    deleteById: function(){

            let id = $("#id").text();

            //ajax 호출시 default가 비동기 호출.
            $.ajax({
                type: "DELETE",
                url: "/api/board/"+id,
                dataType: "json", // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(String) 인데 모양이 json 이라면 JS 오브젝트로 변경을 해줍니다.
                }).done(function(response){
                    alert("삭제가 완료되었습니다.");
                    location.href = "/";
                }).fail(function(error){
                    alert(JSON.stringify(error));
                }); // ajax 통신을 통해서 3개의 데이터를 json으로 변경하여 insert 호출을 할 예졍
            }
    }

index.init();