<!DOCTYPE html>
<head>
    <title>Cписок заметок</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .note-list { margin-bottom: 20px; }
        .note { background-color: #f9f9f9; border: 1px solid #ddd; padding: 10px; margin-top: 5px; display: flex; align-items: center; justify-content: space-between; }
        .note-text { flex-grow: 1; }
        .button { padding: 5px 10px; background-color: #81d381; color: white; border: none; cursor: pointer; }
        .button:hover { background-color: #81d381; }
        .input { padding: 10px; margin: 10px 0; }
        .delete-button { background-color: #dc506c; }
        .delete-button { background-color: #dc506c;}
        .edit-button { background-color: #ffd191; }
        .edit-button { background-color: #ffd191; }
    </style>
</head>
<body>

<h2>Список Ваших заметок</h2>

<div>
    <input type="text" id="noteInput" class="input" placeholder="Enter a note">
    <button onclick="addNote()" class="button">Добавить заметку</button>
</div>

<!-- List of notes -->
<div id="noteList" class="note-list">
    <#list notes as note>
        <div class="note" note_id="${note.id}">
            <span class="note-text">${note.content}</span>
            <button class="button edit-button" onclick="redactNote(event)">📝</button>
            <button class="button delete-button" onclick="deleteNode(event)">🗑</button>
        </div>
    </#list>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    function redactNote(event) {
        let note = event.target.parentElement;
        let text = note.querySelector('.note-text');
        let newText = prompt("Редактировать заметку:", text.textContent);
        if (newText !== null && newText.trim() !== '') {
            $.ajax({
                url: window.location.href,
                method: "post",
                dataType: "json",
                data: {"type": "patch", "id": note.getAttribute("note_id"), "content": newText},
                statusCode:{
                    200: (data) => {
                        text.textContent = newText;
                    }
                }
            })
        }
    }


    function deleteNode(event) {
        let note = event.target.parentElement;

        $.ajax({
            url: window.location.href,
            method: "post",
            dataType: "json",
            data: {"type": "delete", "id": note.getAttribute("note_id")},
            statusCode:{
                200: (data) => {
                    note.remove();
                }
            }
        })
    }


    function printNote(noteContent, data){
        let noteList = document.getElementById('noteList');

        // Create a new note element
        let note = document.createElement('div');
        note.setAttribute("note_id", data.id)
        note.classList.add('note');

        let text = document.createElement('span');
        text.classList.add('note-text');
        text.textContent = noteContent;

        // Add edit button
        let editButton = document.createElement('button');
        editButton.classList.add('button', 'edit-button');
        editButton.textContent = '📝';
        editButton.onclick = function(event) { redactNote(event); };

        let deleteButton = document.createElement('button');
        deleteButton.classList.add('button', 'delete-button');
        deleteButton.textContent = '🗑';
        deleteButton.onclick = deleteNode;

        note.appendChild(text);
        note.appendChild(editButton);
        note.appendChild(deleteButton);
        noteList.appendChild(note);
    }

    function addNote() {
        let input = document.getElementById('noteInput');
        let noteContent = input.value;
        input.value = ''; // Clear the input

        if (noteContent.trim() === '') {
            alert('Пожалуйста, сделайте записи');
            return;
        }
        let response = $.ajax({
            url: window.location.href,
            method: "post",
            dataType: "json",
            data: {"type": "create", "content": noteContent},
            statusCode:{
                200: (data) => {
                    printNote(noteContent, data);
                }
            }
        })
    }
</script>

</body>
</html>
