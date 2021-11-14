LeetCode Plug-in Template Configuration

Code FileName
```
P${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})
```

Code Template
```
${question.content}

package leetcode.editor.en;

public class P${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug}) {
    
    ${question.code}
    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
        
    } 
}
```
