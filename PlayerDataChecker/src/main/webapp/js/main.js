"use strict";
window.onload = () => {
    const requestId = document.querySelector("#requestId");
    const btn = document.getElementById("button");
    const pickUptable = document.getElementById("pickup");
    const targetId = document.querySelectorAll(".target1");
    const targetName = document.querySelectorAll(".target2");
    const targetPass = document.querySelectorAll(".target3");
    const targetSTR = document.querySelectorAll(".target4");
    const targetCON = document.querySelectorAll(".target5");
    const targetDEX = document.querySelectorAll(".target6");
    const targetAGI = document.querySelectorAll(".target7");
    const targetINT = document.querySelectorAll(".target8");
    const targetSEC = document.querySelectorAll(".target9");
    const targetMET = document.querySelectorAll(".target10");
    const targetLUC = document.querySelectorAll(".target11");
    
    let objects = [];

    // オブジェクトのクラス定義
    class DataObject {
        constructor(id, name, pass, STR, CON, DEX, AGI, INT, SEC, MET, LUC) {
            this.id = id;
            this.name = name;
            this.pass = pass;
            this.STR = STR;
            this.CON = CON;
            this.DEX = DEX;
            this.AGI = AGI;
            this.INT = INT;
            this.SEC = SEC;
            this.MET = MET;
            this.LUC = LUC;
        }
    }

    // 各要素を使ってオブジェクトを作成
    for (let i = 0; i < targetId.length; i++) {
        let obj = new DataObject(
            targetId[i].innerText,
            targetName[i].innerText,
            targetPass[i].innerText,
            targetSTR[i].innerText,
            targetCON[i].innerText,
            targetDEX[i].innerText,
            targetAGI[i].innerText,
            targetINT[i].innerText,
            targetSEC[i].innerText,
            targetMET[i].innerText,
            targetLUC[i].innerText
        );
        objects.push(obj);
    }
    // ボタンクリック時の処理
    btn.addEventListener("click", () => {
		alert("hello");
        const id = parseInt(requestId.value) - 1;  // 入力値からIDを取得
        if (id >= 0 && id < objects.length) {
            const data = objects[id];  // 対応するデータを取得
            // テーブルに表示
            pickUptable.innerHTML = `
            	<tr class="top">
					<th>id</th>
					<th>Name</th>
        			<th>Pass</th>
       				<th>Strength</th>
        			<th>Constitution</th>
        			<th>Dexterity</th>
        			<th>Agility</th>
        			<th>Intelligence</th>
        			<th>Sensing</th>
        			<th>Mentality</th>
        			<th>Luck</th>
				</tr>
                <tr>
                    <td>${data.id}</td>
                    <td>${data.name}</td>
                    <td>${data.pass}</td>
                    <td>${data.STR}</td>
                    <td>${data.CON}</td>
                    <td>${data.DEX}</td>
                    <td>${data.AGI}</td>
                    <td>${data.INT}</td>
                    <td>${data.SEC}</td>
                    <td>${data.MET}</td>
                    <td>${data.LUC}</td>
                </tr>
            `;
        } else {
            alert("無効なIDです");
        }
    });
};
