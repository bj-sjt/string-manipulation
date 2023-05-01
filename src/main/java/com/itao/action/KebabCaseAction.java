package com.itao.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.itao.util.StringUtil;
import org.jetbrains.annotations.NotNull;

/**
 * 短横线与驼峰转换
 */
public class KebabCaseAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        if (editor == null)
            return;
        SelectionModel selectionModel = editor.getSelectionModel();
        int start = selectionModel.getSelectionStart();
        int end = selectionModel.getSelectionEnd();
        String selectedText = selectionModel.getSelectedText();
        if (StringUtil.isBlank(selectedText)) {
            return;
        }
        Document document = editor.getDocument();
        if (selectedText.contains("-")){
            WriteCommandAction
                    .runWriteCommandAction(
                            project,
                            () -> document.replaceString(start, end, StringUtil.kebabCase2Hump(selectedText))
                    );
        } else {
            WriteCommandAction
                    .runWriteCommandAction(
                            project,
                            () -> document.replaceString(start, end, StringUtil.hump2KebabCase(selectedText))
                    );
        }
    }
}
