package de.darkatra.bfme2.ini.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

open class SageEngineIniPsiElement(node: ASTNode) : ASTWrapperPsiElement(node)

class SageEngineIniBlock(node: ASTNode) : SageEngineIniPsiElement(node)

class SageEngineIniPropertyAssignment(node: ASTNode) : SageEngineIniPsiElement(node)

class SageEngineIniMacroStatement(node: ASTNode) : SageEngineIniPsiElement(node)

class SageEngineIniComment(node: ASTNode) : SageEngineIniPsiElement(node)

class SageEngineIniScriptBlock(node: ASTNode) : SageEngineIniPsiElement(node)